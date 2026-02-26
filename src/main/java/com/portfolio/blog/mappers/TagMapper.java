package com.portfolio.blog.mappers;

import com.portfolio.blog.domain.dto.tag.TagRequest;
import com.portfolio.blog.domain.dto.tag.TagResponse;
import com.portfolio.blog.domain.entities.PostEntity;
import com.portfolio.blog.domain.entities.StatusEntity;
import com.portfolio.blog.domain.entities.TagEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagMapper {

    TagEntity requestToEntity(TagRequest tag);

    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    TagResponse entityToResponse(TagEntity entity);

    @Named("calculatePostCount")
    default long calculatePostCount(List<PostEntity> posts) {

        if(posts == null) return 0;

        return posts.stream()
                .filter(post -> StatusEntity.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
