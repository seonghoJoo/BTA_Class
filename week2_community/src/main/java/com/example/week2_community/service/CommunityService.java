package com.example.week2_community.service;

import com.example.week2_community.dto.request.ArticleRequsetDto;
import com.example.week2_community.dto.request.ReplyRequestDto;
import com.example.week2_community.dto.response.ArticleResponseDto;
import reactor.core.publisher.Mono;

public interface CommunityService {
    Mono<ArticleResponseDto> getArticle(Long articleId);

    Mono<ArticleResponseDto> createArticle(Mono<ArticleRequsetDto> article);

    Mono<ReplyRequestDto> createReply(Mono<ReplyRequestDto> article);

    Mono<ArticleResponseDto> updateArticleBlur(Long articleId);

    Mono<ReplyRequestDto> updateReplyBlur(Long replyId);
}
