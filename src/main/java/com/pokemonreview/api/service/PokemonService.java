package com.pokemonreview.api.service;

import com.pokemonreview.api.data.dto.PokemonDto;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface PokemonService {
    PokemonDto createPokemon(PokemonDto pokemonDto);

    List<PokemonDto> getAllPokemon();

    PokemonDto getPokemonById(int id);

    PokemonDto updatePokemon(PokemonDto pokemonDto, int id);

    void deletePokemonId(int id);
}
