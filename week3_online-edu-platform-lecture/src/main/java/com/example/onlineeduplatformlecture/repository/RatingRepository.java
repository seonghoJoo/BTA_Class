package com.example.onlineeduplatformlecture.repository;

import com.example.onlineeduplatformlecture.model.Rating;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RatingRepository extends ReactiveCrudRepository<Rating, Long> {

}
