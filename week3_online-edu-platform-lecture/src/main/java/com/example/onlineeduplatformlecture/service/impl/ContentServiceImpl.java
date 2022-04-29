package com.example.onlineeduplatformlecture.service.impl;

import com.example.onlineeduplatformlecture.model.Content;
import com.example.onlineeduplatformlecture.repository.ContentRepository;
import com.example.onlineeduplatformlecture.service.ContentService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;

    ContentServiceImpl(ContentRepository contentRepository){
        this.contentRepository = contentRepository;
    }

    // GET /lectures/{lectureId}/contents (콘텐츠 리스트 조회)
    public Flux<Content> getContentList(int  lectureId){
        return contentRepository.findContentByLectureId(lectureId);
    }

    // GET /lectures/{lectureId}/contents/{contentId} (콘텐츠 열람)
    public Mono<Content> getContent(int lectureId, int contentId){
        return contentRepository.findByLectureIdAndContentId(lectureId, contentId);
    }

}
