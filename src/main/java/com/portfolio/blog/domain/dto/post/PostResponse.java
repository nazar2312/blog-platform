package com.portfolio.blog.domain.dto.post;

import com.portfolio.blog.domain.dto.Tag;
import com.portfolio.blog.domain.dto.user.UserResponse;
import com.portfolio.blog.domain.entities.Status;
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
    UserResponse user;
    LocalDateTime created;
    Status status;
    Integer readingTime;
    String categoryName;
    Set<Tag> tags;
}
