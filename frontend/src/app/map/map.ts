import { Component, ElementRef, OnDestroy, OnInit, ViewChild, inject } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { PLATFORM_ID } from '@angular/core';
import { Fountain } from '../fountain';
import { FountainService } from '../fountain.service';
import { HttpErrorResponse } from '@angular/common/http';
import mapboxgl from 'mapbox-gl';

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
  public fountains: Fountain[] = [];

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

      this.getFountains();
    }
  }

  constructor(private fountainService: FountainService){}

  public getFountains(): void {
    this.fountainService.getFountains().subscribe(
      (response: Fountain[]) => {
        this.fountains = response;
        console.log(this.fountains.length);
        this.fountains.forEach(fountain => {
          new mapboxgl.Marker()
            .setLngLat([fountain.longitude, fountain.latitude])
            .addTo(this.map);
        })
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
}