package com.portfolio.blog.domain.dto;

import com.portfolio.blog.domain.entities.PostEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record User(
        UUID id,
        String username,
        String email,
        String password,
        LocalDateTime created,
        LocalDateTime updated,
        List<PostEntity> posts
) {
}
