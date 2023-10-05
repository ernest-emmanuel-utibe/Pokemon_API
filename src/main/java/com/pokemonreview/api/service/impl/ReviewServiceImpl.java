package com.pokemonreview.api.service.impl;

import com.pokemonreview.api.data.dto.ReviewDto;
import com.pokemonreview.api.data.model.Pokemon;
import com.pokemonreview.api.data.model.Review;
import com.pokemonreview.api.data.repository.PokemonRepository;
import com.pokemonreview.api.data.repository.ReviewRepository;
import com.pokemonreview.api.exception.PokemonNotFoundException;
import com.pokemonreview.api.exception.ReviewNotFoundException;
import com.pokemonreview.api.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    private PokemonRepository pokemonRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, PokemonRepository pokemonRepository) {
        this.reviewRepository = reviewRepository;
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public ReviewDto createReview(int pokemonId, ReviewDto reviewDto) {
        Review review = mapToEntity(reviewDto);

        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(() -> new PokemonNotFoundException("Pokemon with associated review not found."));

        review.setPokemon(pokemon);

        Review newReview = reviewRepository.save(review);

        return mapToDto(newReview);
    }

    @Override
    public List<ReviewDto> getReviewsByPokemonId(int id) {
        List<Review> reviews = reviewRepository.findByPokemonId(id);

        return reviews.stream().map(review1 -> mapToDto(review1)).collect(Collectors.toList());
    }

    @Override
    public ReviewDto getReviewsById(int reviewId, int pokemonId) {
        // Find the Pokemon
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(() -> new PokemonNotFoundException("Pokemon with associated review not found."));

        // Find the Review
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new ReviewNotFoundException("Review with associated pokemon not found."));

        // Provide more exception handling
        if (review.getPokemon().getId() != pokemon.getId()) {
            throw new ReviewNotFoundException("This review do not belong to a pokemon");
        }
        return mapToDto(review);
    }




    private ReviewDto mapToDto(Review newReview) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(newReview.getId());
        reviewDto.setTitle(newReview.getTitle());
        reviewDto.setContent(newReview.getContent());
        reviewDto.setStars(newReview.getStars());
        return reviewDto;
    }

    private Review mapToEntity(ReviewDto reviewDto) {
        Review review = new Review();
        review.setId(reviewDto.getId());
        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setStars(reviewDto.getStars());
        return review;

    }
}
