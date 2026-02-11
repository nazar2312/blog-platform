package com.portfolio.blog.domain.dto.postDto;

import com.portfolio.blog.domain.dto.Category;
import com.portfolio.blog.domain.dto.Tag;
import com.portfolio.blog.domain.dto.User;
import com.portfolio.blog.domain.entities.StatusEntity;
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
    User user;
    StatusEntity status;
    Category categories;
    Set<Tag> tags;
}
