package com.example.onlineeduplatformlecture.service;

import com.example.onlineeduplatformlecture.model.Content;
import com.example.onlineeduplatformlecture.model.Lecture;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ContentService {

    // GET /lectures/{lectureId}/contents (콘텐츠 리스트 조회)
    Flux<Content> getContentList(int  lectureId);

    // GET /lectures/{lectureId}/contents/{contentId} (콘텐츠 열람)
    Mono<Content> getContent(int lectureId, int contentId);

}
