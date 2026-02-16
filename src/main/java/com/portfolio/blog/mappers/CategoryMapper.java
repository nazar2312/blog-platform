package com.portfolio.blog.mappers;

import com.portfolio.blog.domain.dto.category.Category;
import com.portfolio.blog.domain.dto.category.CategoryRequest;
import com.portfolio.blog.domain.entities.CategoryEntity;
import com.portfolio.blog.domain.entities.PostEntity;
import com.portfolio.blog.domain.entities.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    Category toDto(CategoryEntity entity);

    CategoryEntity toEntity(Category category);

    Category fromRequestToDto(CategoryRequest request);

    CategoryEntity fromRequestToEntity(CategoryRequest request);

    @Named("calculatePostCount")
    default long calculatePostCount(List<PostEntity> posts) {

        {
            if(null == posts) return 0;
        }
        return posts.stream()
                .filter(post -> Status.PUBLISHED.equals(post.getStatus()))
                .count();
    }



}
