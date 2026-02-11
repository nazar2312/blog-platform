package com.portfolio.blog.mappers;

import com.portfolio.blog.domain.dto.postDto.PostRequest;
import com.portfolio.blog.domain.dto.postDto.PostResponse;
import com.portfolio.blog.domain.entities.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    PostEntity requestToEntity(PostRequest post);
    PostResponse entityToResponse(PostEntity post);

}
