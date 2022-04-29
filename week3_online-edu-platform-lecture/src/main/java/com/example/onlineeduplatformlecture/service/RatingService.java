package com.example.onlineeduplatformlecture.service;

import com.example.onlineeduplatformlecture.model.Rating;
import java.util.List;
import reactor.core.publisher.Mono;

public interface RatingService {

    double getAverageRate(List<Rating> ratingList);

    Mono<Rating> saveRate(Rating rating);
}
