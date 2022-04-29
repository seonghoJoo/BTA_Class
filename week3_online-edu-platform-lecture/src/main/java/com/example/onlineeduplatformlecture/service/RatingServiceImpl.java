package com.example.onlineeduplatformlecture.service;

import com.example.onlineeduplatformlecture.model.Rating;
import com.example.onlineeduplatformlecture.repository.RatingRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public double getAverageRate(List<Rating> ratingList) {
        return 0;
//        return ratingList.stream()
//                .mapToDouble(Rating::getRating)
//                .average()
//                .orElse(0);
    }

    @Override
    public Mono<Rating> saveRate(Rating rating) {
        return ratingRepository.save(rating);
    }
}
