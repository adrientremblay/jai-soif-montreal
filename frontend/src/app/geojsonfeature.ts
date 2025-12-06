import { FountainProperties } from "./fountainproperties";

export interface GeoJsonFeature {
    geometry: any;
    properties: FountainProperties;
    type: string;
}