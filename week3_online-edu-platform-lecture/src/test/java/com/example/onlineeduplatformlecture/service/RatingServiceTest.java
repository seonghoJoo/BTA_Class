package com.example.onlineeduplatformlecture.service;

import com.example.onlineeduplatformlecture.model.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class RatingServiceTest {

//    RatingService ratingService;
//    Rating rating;
//    Mono<Rating> ratingMono;
//    List<Rating> ratingList;
//
//    @BeforeEach
//    void setUp() {
//        this.ratingService = new RatingService();
//        this.rating = new Rating(0,0,0,0,"잠와요");
//        List<Rating> ratingList = new ArrayList<>();
//        ratingList.add(new Rating(0,0,0,0,"졸려요"));
//        ratingList.add(new Rating(1,0,1,0,"잠와요"));
//        ratingList.add(new Rating(2,0,2,0,"배고파요"));
//        this.ratingList = ratingList;
//        this.ratingMono = Mono.just(new Rating(0,0,0,0,"잠와요"));
//    }
//
//    @Test
//    void 별점저장하기(){
//        Rating result = ratingService.saveRating(rating);
//        System.out.println(result);
//        assertThat(result).isSameAs(rating);
//    }
//    @Test
//    void 평균별점가져오기(){
//        float result = ratingService.getRating();
//        assertThat(result).isEqualTo(2.6666667f);
//    }
//    @Test
//    void 별점리스트가져오기(){
//        assertThat(ratingService.getRatingList())
//                .isInstanceOf(List.class)
//                .isNotEmpty();
//    }
}