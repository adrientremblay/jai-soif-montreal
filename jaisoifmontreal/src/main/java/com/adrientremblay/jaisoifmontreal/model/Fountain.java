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
    private Point geom;

    public Fountain(String borough, String placeName, String placeType, String intersection, String notes, Point geom) {
        this.borough = borough;
        this.placeName = placeName;
        this.placeType = placeType;
        this.intersection = intersection;
        this.notes = notes;
        this.geom = geom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Point getGeom() {
        return geom;
    }

    public void setGeom(Point geom) {
        this.geom = geom;
    }

    // Optional convenience methods
    public double getLatitude() {
        return geom.getY();
    }

    public double getLongitude() {
        return geom.getX();
    }

    @Override
    public String toString() {
        return "Fountain{" +
                "id=" + id +
                ", borough='" + borough + '\'' +
                ", placeName='" + placeName + '\'' +
                ", placeType='" + placeType + '\'' +
                ", intersection='" + intersection + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
