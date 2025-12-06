package com.adrientremblay.jaisoifmontreal;

import com.adrientremblay.jaisoifmontreal.model.Fountain;
import com.adrientremblay.jaisoifmontreal.model.GeoJsonPoint;
import com.adrientremblay.jaisoifmontreal.service.FountainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fountain")
public class FountainResource {
    private final FountainService fountainService;

    public FountainResource(FountainService fountainService) {
        this.fountainService = fountainService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<GeoJsonPoint>> getAllFountains() {
        List<Fountain> fountains = fountainService.findAllFountains();

        List<GeoJsonPoint> points = fountains.stream().map(fountain -> new GeoJsonPoint(
                fountain.getLongitude(),
                fountain.getLatitude(),
                Map.of("Borough", fountain.getBorough() , "Place Name", fountain.getPlaceName(), "Place Type", fountain.getPlaceType(),"Intersection", fountain.getIntersection(), "Notes", fountain.getNotes(), "Place Type French", fountain.getPlaceTypeFrench(), "Notes French", fountain.getNotesFrench())
        )).toList();

        return new ResponseEntity<>(points, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/find/{id}")
    public ResponseEntity<Fountain> getFountainById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(fountainService.findFountainById(id), HttpStatus.OK);
    }
}
