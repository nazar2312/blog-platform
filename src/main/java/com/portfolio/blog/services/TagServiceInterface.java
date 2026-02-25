package com.portfolio.blog.services;

import com.portfolio.blog.domain.dto.post.PostRequest;
import com.portfolio.blog.domain.entities.TagEntity;

import java.util.Set;

public interface TagServiceInterface {
    Set<TagEntity> verifyTags(PostRequest request);
}
