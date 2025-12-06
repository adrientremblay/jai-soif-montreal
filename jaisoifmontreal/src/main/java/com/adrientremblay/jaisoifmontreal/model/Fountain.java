package com.adrientremblay.jaisoifmontreal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Point;

import java.io.Serializable;

@Entity
@Table(name = "fountains")
public class Fountain implements Serializable {
    @Id
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String borough;
    private String placeName;
    private String placeType;
    private String intersection;
    private String notes;
    @Column(columnDefinition = "geometry(Point,4326)")
    private Point geom;
    @Column(name = "place_type_fr")
    private String placeTypeFrench;
    @Column(name = "notes_fr")
    private String notesFrench;

    // === Hibernate requires this ===
    protected Fountain() {
    }

    public Fountain(String borough, String placeName, String placeType, String intersection, String notes, Point geomm, String placeTypeFrench, String notesFrench) {
        this.borough = borough;
        this.placeName = placeName;
        this.placeType = placeType;
        this.intersection = intersection;
        this.notes = notes;
        this.geom = geom;
        this.placeTypeFrench = placeTypeFrench;
        this.notesFrench = notesFrench;
    }

    public Integer getId() {
        return id;
    }

    public String getBorough() {
        return borough;
    }

    public String getPlaceName() {
        return placeName != null ? placeName : "";
    }

    public String getPlaceType() {
        return placeType != null ? placeType : "";
    }

    public String getIntersection() {
        return intersection != null ? intersection : "";
    }

    public String getNotes() {
        return notes != null ? notes : "";
    }

    public double getLatitude() {
        return geom.getY();
    }

    public double getLongitude() {
        return geom.getX();
    }

    public String getPlaceTypeFrench() {
        return placeTypeFrench != null ? placeTypeFrench : "";
    }

    public String getNotesFrench() {
        return notesFrench != null ? notesFrench : "";
    }
}
