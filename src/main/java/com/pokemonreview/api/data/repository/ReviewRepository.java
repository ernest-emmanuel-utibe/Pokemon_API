package com.pokemonreview.api.data.repository;

import com.pokemonreview.api.data.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    // A method that will search by nested queries
    List<Review> findByPokemonId(int pokemonId);
}
