package com.portfolio.blog.domain.dto.post;

import com.portfolio.blog.domain.dto.Tag;
import com.portfolio.blog.domain.dto.category.CategoryRequest;
import com.portfolio.blog.domain.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    String title;
    String content;
    Status status;
    CategoryRequest category;
    Set<Tag> tags;
}
