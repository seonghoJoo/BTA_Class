package com.example.week2_community.controller;

import com.example.week2_community.domain.User;
import com.example.week2_community.domain.UserRole;
import com.example.week2_community.dto.request.ArticleRequsetDto;
import com.example.week2_community.dto.request.ReplyRequestDto;
import com.example.week2_community.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class CommunityHandler {

    @Autowired
    CommunityService communityService;

    @Autowired
    WebClient webClient;

    Long studentId = 2L;

    //                .GET("/article/{articleID}", accept(APPLICATION_JSON), communityHandler::getArticle)
    //                .POST("/article", accept(APPLICATION_JSON), communityHandler::createArticle)
    //                .POST("/article/{articleId}/reply", accept(APPLICATION_JSON), communityHandler::createReply)
    //                .PUT("/article/{articleId}", accept(APPLICATION_JSON), communityHandler::updateArticleBlur)
    //                .PUT("/reply/{replyId}", accept(APPLICATION_JSON), communityHandler::updateReplyBlur)
    @Secured({UserRole.Authority.STUDENT, UserRole.Authority.LECTURER, UserRole.Authority.ADMIN})
    public Mono<ServerResponse> getArticle(ServerRequest request) {

        Long articleId = Long.parseLong(request.pathVariable("articleID"));

        return  ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(communityService.getArticle(articleId));
    }

    @Secured({UserRole.Authority.STUDENT, UserRole.Authority.LECTURER, UserRole.Authority.ADMIN})
    public Mono<ServerResponse> createArticle(ServerRequest request) {
        Mono<ArticleRequsetDto> article = request.bodyToMono(ArticleRequsetDto.class);
        return  ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(communityService.createArticle(article));
    }

    @Secured({UserRole.Authority.STUDENT, UserRole.Authority.LECTURER, UserRole.Authority.ADMIN})
    public Mono<ServerResponse> createReply(ServerRequest request) {
        Long articleId = Long.parseLong(request.pathVariable("articleID"));
        Mono<ReplyRequestDto> article = request.bodyToMono(ReplyRequestDto.class);
        return  ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(communityService.createReply(article));
    }

    @Secured({UserRole.Authority.ADMIN})
    public Mono<ServerResponse> updateArticleBlur(ServerRequest request) {
        Long articleId = Long.parseLong(request.pathVariable("articleID"));
        return  ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(communityService.updateArticleBlur(articleId));
    }

    @Secured({UserRole.Authority.ADMIN})
    public Mono<ServerResponse> updateReplyBlur(ServerRequest request) {
        Long replyId = Long.parseLong(request.pathVariable("replyId"));
        return  ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(communityService.updateReplyBlur(replyId));
    }

}
