package com.portfolio.blog.mappers;

import com.portfolio.blog.domain.dto.category.CategoryResponse;
import com.portfolio.blog.domain.dto.post.PostRequest;
import com.portfolio.blog.domain.dto.post.PostResponse;
import com.portfolio.blog.domain.dto.user.UserResponse;
import com.portfolio.blog.domain.entities.CategoryEntity;
import com.portfolio.blog.domain.entities.PostEntity;
import com.portfolio.blog.domain.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    PostEntity requestToEntity(PostRequest post);
    PostResponse entityToResponse(PostEntity post);
    UserResponse userToResponse(UserEntity user);
    CategoryResponse categoryToResponse(CategoryEntity category);
}
