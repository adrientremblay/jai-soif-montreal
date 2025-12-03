package com.adrientremblay.jaisoifmontreal.service;

import com.adrientremblay.jaisoifmontreal.model.Fountain;
import com.adrientremblay.jaisoifmontreal.repo.FountainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FountainService {
    private final FountainRepo fountainRepo;

    @Autowired
    public FountainService(FountainRepo fountainRepo) {
        this.fountainRepo = fountainRepo;
    }

    public Fountain addFountain(Fountain fountain) {
        return fountainRepo.save(fountain);
    }

    public List<Fountain> findAllFountains() {
        return fountainRepo.findAll();
    }

    public Fountain updateFountain(Fountain fountain) {
        return fountainRepo.save(fountain);
    }

    public void deleteFountain(Integer id) {
        fountainRepo.deleteFountainById(id);
    }

    public Fountain findFountainById(Integer id) {
        return fountainRepo.findFountainById(id).orElseThrow(() -> new FountainNotFoundException("Fountain with id " + id + " not found."));
    }
}
