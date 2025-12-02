package com.adrientremblay.jaisoifmontreal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Fountain implements Serializable {
    @Id
    @Column(nullable = false, updatable = false)
    private Long id;
    private String borough;
    private String placeName;
    private String placeType;
    private String intersection;
    private String notes;
    private Double latitude;
    private Double Longitude;

    public Fountain(String borough, String placeName, String placeType, String intersection, String notes, Double latitude, Double longitude) {
        this.borough = borough;
        this.placeName = placeName;
        this.placeType = placeType;
        this.intersection = intersection;
        this.notes = notes;
        this.latitude = latitude;
        Longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getIntersection() {
        return intersection;
    }

    public void setIntersection(String intersection) {
        this.intersection = intersection;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }
}
