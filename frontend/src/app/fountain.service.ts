import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { GeoJsonFeature } from "./geojsonfeature";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class FountainService {
    private apiServerUrl = 'http://localhost:8080';

    constructor(private http: HttpClient) {}

    public getFountains(): Observable<GeoJsonFeature[]> {
        return this.http.get<any>(this.apiServerUrl+'/fountain/all');
    }
}