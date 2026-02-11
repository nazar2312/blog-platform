package com.portfolio.blog.domain.dto;

import com.portfolio.blog.domain.entities.PostEntity;

import java.util.List;
import java.util.UUID;

public record Tag(
        UUID id,
        String name,
        List<PostEntity> posts
) {
}
