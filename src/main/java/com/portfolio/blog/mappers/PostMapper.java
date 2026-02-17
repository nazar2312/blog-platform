package com.portfolio.blog.mappers;

import com.portfolio.blog.domain.dto.post.PostRequest;
import com.portfolio.blog.domain.dto.post.PostResponse;
import com.portfolio.blog.domain.entities.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {
        CategoryMapper.class,
        TagMapper.class,
        UserMapper.class})
public interface PostMapper {

    PostEntity requestToEntity(PostRequest post);
    PostResponse entityToResponse(PostEntity post);
}
