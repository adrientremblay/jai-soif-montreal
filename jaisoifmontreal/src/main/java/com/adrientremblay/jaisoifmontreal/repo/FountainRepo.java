package com.adrientremblay.jaisoifmontreal.repo;

import com.adrientremblay.jaisoifmontreal.model.Fountain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FountainRepo extends JpaRepository<Fountain, Integer> {
    public void deleteFountainById(Integer id);
    public Optional<Fountain> findFountainById(Integer id);
}
