package com.example.onlineeduplatformlecture.router;

import com.example.onlineeduplatformlecture.handler.RatingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
public class RatingRouter {

    @Bean
    public RouterFunction<ServerResponse> ratingRouters(RatingHandler ratingHandler) {
        return RouterFunctions.route()
                .GET("/lectures/{lectureId}/rating", ratingHandler::getRatingList)
                .GET("/lectures/{lectureId}/rating/{ratingId}", ratingHandler::getRating)
                .POST("/lectures/{lectureId}/rating", ratingHandler::saveRating)
                .build();
    }

}
