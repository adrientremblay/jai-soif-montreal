import { Component, ElementRef, OnDestroy, OnInit, ViewChild, inject } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { PLATFORM_ID } from '@angular/core';

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

  async ngOnInit() {
    if (isPlatformBrowser(this.platformId)) { // SSR check to ensure this runs in the browser as GL JS requires a browser environment
      const mapboxgl = (await import('mapbox-gl')).default // dynamically import mapbox-gl as the default export

      // Create a new map instance
      this.map = new mapboxgl.Map({
        accessToken: 'pk.eyJ1IjoiYWRyaWVudHJlbWJsYXkiLCJhIjoiY21pZGkzZmhqMDZydjJqcG51cTV0cDMzOCJ9.uBD-0FwBXgdibDCiSF4Hlw',
        container: this.mapContainer.nativeElement, // Reference to the map container element
        center: [-98.54818, 40.00811], // Center coordinates for map over the continental US
        zoom: 4, // Initial zoom level
      });
    }
  }

  ngOnDestroy(): void {
    if (this.map) {
      this.map.remove();
    }
  }
}