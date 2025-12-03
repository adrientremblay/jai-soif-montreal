package com.adrientremblay.jaisoifmontreal;

import com.adrientremblay.jaisoifmontreal.model.Fountain;
import com.adrientremblay.jaisoifmontreal.service.FountainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fountain")
public class FountainResource {
    private final FountainService fountainService;

    public FountainResource(FountainService fountainService) {
        this.fountainService = fountainService;
    }

    @GetMapping
    public ResponseEntity<List<Fountain>> getAllFountains() {
        return new ResponseEntity<>(fountainService.findAllFountains(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Fountain> getFountainById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(fountainService.findFountainById(id), HttpStatus.OK);
    }
}
