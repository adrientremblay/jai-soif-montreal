import { Component, ElementRef, OnDestroy, OnInit, ViewChild, inject } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { PLATFORM_ID } from '@angular/core';
import { GeoJsonFeature } from '../geojsonfeature';
import { FountainService } from '../fountain.service';
import { HttpErrorResponse } from '@angular/common/http';
import mapboxgl, { MapEvent } from 'mapbox-gl';

@Component({
  selector: 'app-map', 
  standalone: true,
  templateUrl: './map.html',
  styleUrls: ['./map.css']
})
export class MapComponent implements OnInit, OnDestroy {
  @ViewChild('mapContainer', { static: true }) mapContainer!: ElementRef;
  map: any;
  private platformId = inject(PLATFORM_ID);
  public featuresList: GeoJsonFeature[] = [];

  async ngOnInit() {
    if (isPlatformBrowser(this.platformId)) { // SSR check to ensure this runs in the browser as GL JS requires a browser environment
      const mapboxgl = (await import('mapbox-gl')).default // dynamically import mapbox-gl as the default export

      // Create a new map instance
      this.map = new mapboxgl.Map({
        accessToken: 'pk.eyJ1IjoiYWRyaWVudHJlbWJsYXkiLCJhIjoiY21pZGkzZmhqMDZydjJqcG51cTV0cDMzOCJ9.uBD-0FwBXgdibDCiSF4Hlw',
        container: this.mapContainer.nativeElement, // Reference to the map container element
        center: [-73.5674, 45.5019, ], // Center coordinates for map over the continental US
        zoom: 11, // Initial zoom level
      });

      this.map.on('load', () => {
        this.getFountains();
      });
    }
  }

  constructor(private fountainService: FountainService){}

  public getFountains(): void {
    this.fountainService.getFountains().subscribe(
      (response: GeoJsonFeature[]) => {
        this.featuresList = response;

        this.map.addSource('my-data', {
            "type": "geojson",
            "data": {
                "type": "FeatureCollection",
                "features" : this.featuresList, 
            }
        });

        this.map.addLayer({
          id: 'fountains',
          type: 'circle',
          source: 'my-data',
          paint: {
            'circle-radius': 6,
            'circle-color': '#2222B4'
          }      
        });

        // When a click event occurs on a feature in the places layer, open a popup at the
        // location of the feature, with description HTML from its properties.
        this.map.addInteraction('places-click-interaction', {
            type: 'click',
            target: { layerId: 'fountains' },
            handler: (e: any) => {
                // Copy coordinates array.
                const coordinates = e.feature.geometry.coordinates.slice();
                const description = this.formatDescriptionFromFountainProperties(e.feature.properties);

                new mapboxgl.Popup()
                    .setLngLat(coordinates)
                    .setHTML(description)
                    .addTo(this.map);
            }
        });

    },
      (error: HttpErrorResponse) => {
        console.error(error.message);
      }
    )
  }

  ngOnDestroy(): void {
    if (this.map) {
      this.map.remove();
    }
  }

  private formatDescriptionFromFountainProperties(fountainProperties: any): string {
    console.log(Object.entries(fountainProperties));
    let description : string = Object.entries(fountainProperties)
      .filter((value: [string, unknown]) => value[1] != "")
      .map((value: [string, unknown]) => value[0] + ": " + value[1])
      .join("<br /><br />");


    return description;
  }
}