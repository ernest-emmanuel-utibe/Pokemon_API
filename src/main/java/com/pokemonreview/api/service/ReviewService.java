package com.pokemonreview.api.service;

import com.pokemonreview.api.data.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto createReview(int pokemonId, ReviewDto reviewDto);

    List<ReviewDto> getReviewsByPokemonId(int id);

    ReviewDto getReviewsById(int reviewId, int pokemonId);
}
