package com.adrientremblay.jaisoifmontreal.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeoJsonPoint implements Serializable {
    private String type = "Feature";
    private Map<String, Object> properties = new HashMap<>();
    private Map<String, Object> geometry;

    public GeoJsonPoint(double lon, double lat, Map<String, Object> props) {
        this.properties = props;

        this.geometry = new HashMap<>();
        geometry.put("type", "Point");
        geometry.put("coordinates", List.of(lon, lat));
    }

    public String getType() {
        return type;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public Map<String, Object> getGeometry() {
        return geometry;
    }
}