package com.pokemonreview.api.service.impl;

import com.pokemonreview.api.data.dto.PokemonDto;
import com.pokemonreview.api.data.model.Pokemon;
import com.pokemonreview.api.data.repository.PokemonRepository;
import com.pokemonreview.api.exception.PokemonNotFoundException;
import com.pokemonreview.api.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {
    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public PokemonDto createPokemon(PokemonDto pokemonDto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

        Pokemon newSavedPokemon = pokemonRepository.save(pokemon);

        PokemonDto pokemonResponse = new PokemonDto();
        pokemonResponse.setId(newSavedPokemon.getId());
        pokemonResponse.setName(newSavedPokemon.getName());
        pokemonResponse.setType(newSavedPokemon.getType());
        return pokemonResponse;
    }

    @Override
    public List<PokemonDto> getAllPokemons() {
//        Pokemon pokemon3 = pokemonRepository.findById(3333).orElseThrow(() -> new PokemonNotFoundException("Pokemon could not be found by id"));
        List<Pokemon> pokemon = pokemonRepository.findAll();
        // Map because it returns a new list
        return pokemon.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
    }

    private PokemonDto mapToDto(Pokemon pokemon) {
        PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setId(pokemon.getId());
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setType(pokemon.getType());
        return pokemonDto;
    }

    private Pokemon mapToEntity(PokemonDto pokemonDto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());
        return pokemon;
    }
}
