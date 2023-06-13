package com.pokemonreview.api.data.repository;

import com.pokemonreview.api.data.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
}
