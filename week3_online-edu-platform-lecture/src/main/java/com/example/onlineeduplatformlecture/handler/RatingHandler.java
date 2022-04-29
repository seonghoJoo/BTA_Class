package com.example.onlineeduplatformlecture.handler;

import com.example.onlineeduplatformlecture.model.Rating;
import com.example.onlineeduplatformlecture.repository.RatingRepository;
import com.example.onlineeduplatformlecture.service.PracticeProducerService;
import com.example.onlineeduplatformlecture.service.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class RatingHandler {

    @Autowired
    RatingRepository ratingRepository;
    @Autowired
    RatingService ratingService;
    @Autowired
    PracticeProducerService practiceProducerService;
    @Autowired
    ModelMapper modelMapper;


    public Mono<ServerResponse> getRatingList(ServerRequest request) {

        Flux<Rating> articles = this.ratingRepository.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(articles, Rating.class);
    }

    public Mono<ServerResponse> getRating(ServerRequest request) {

        Long ratingId = Long.parseLong(request.pathVariable("ratingId"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<Rating> ratingMono = this.ratingRepository.findById(ratingId);
        return ratingMono
                .flatMap(rating -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just(rating), Rating.class))
                .switchIfEmpty(notFound);

    }

    public Mono<ServerResponse> saveRating(ServerRequest request) {
        Mono<Rating> ratingMono = request.bodyToMono(Rating.class)
                .onErrorResume(throwable -> {
                    System.out.println(throwable.getMessage());
                    return Mono.error(new RuntimeException(throwable));
                })
                .map(r-> {
                    Rating rating = new Rating(r.getLectureId(), r.getUserId(), r.getRating(), r.getComment());
                    practiceProducerService.sendMessage(rating);
                    return rating;
                });

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(
                ratingMono.flatMap(this.ratingRepository::save), Rating.class);
    }
}
