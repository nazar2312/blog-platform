package com.portfolio.blog.domain.dto.postDto;

import com.portfolio.blog.domain.dto.User;
import com.portfolio.blog.domain.entities.CategoryEntity;
import com.portfolio.blog.domain.entities.StatusEntity;
import com.portfolio.blog.domain.entities.TagEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    UUID id;
    String title;
    LocalDateTime created;
    User user;
    StatusEntity status;
    Integer readingTime;
    CategoryEntity categories;
    Set<TagEntity> tags;
}
