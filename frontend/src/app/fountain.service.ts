import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Fountain } from "./fountain";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class FountainService {
    private apiServerUrl = '';

    constructor(private http: HttpClient) {}

    public getFountains(): Observable<Fountain[]> {
        return this.http.get<any>(this.apiServerUrl+']/fountain/all');
    }
}