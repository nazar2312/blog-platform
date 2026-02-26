package com.portfolio.blog.services;

import com.portfolio.blog.domain.dto.post.PostRequest;
import com.portfolio.blog.domain.dto.tag.TagRequest;
import com.portfolio.blog.domain.dto.tag.TagResponse;
import com.portfolio.blog.domain.entities.TagEntity;

import java.util.List;
import java.util.UUID;

public interface TagServiceInterface {
    TagResponse create(TagRequest request);
    List<TagResponse> findAll();
    void deleteById(UUID uuid);
    List<TagEntity> verifyTags(PostRequest request);
}
