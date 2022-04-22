package com.example.week2_community.config;

import com.example.week2_community.controller.CommunityHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterConfig {

    //Router Function 모델
    @Bean
    public RouterFunction<ServerResponse> routerExample(CommunityHandler communityHandler) {
        return RouterFunctions.route()
                .GET("/article/{articleId}", accept(APPLICATION_JSON), communityHandler::getArticle)
                .POST("/article/{articleId}/reply", accept(APPLICATION_JSON), communityHandler::createArticle)
                .POST("/reply", accept(APPLICATION_JSON), communityHandler::createReply)
                .PUT("/article/{articleId}", accept(APPLICATION_JSON), communityHandler::updateArticleBlur)
                .PUT("/reply/{replyId}", accept(APPLICATION_JSON), communityHandler::updateReplyBlur)
                .build();
    }


}
