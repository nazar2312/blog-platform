package com.portfolio.blog.services;

import com.portfolio.blog.domain.dto.postDto.PostRequest;
import com.portfolio.blog.domain.dto.postDto.PostResponse;

import java.util.List;
import java.util.UUID;

public interface PostServiceInterface {

    List<PostResponse> findAll();
    PostResponse findOne(UUID id);
    PostResponse create(PostRequest request);
    PostResponse update();
    void delete();
}
