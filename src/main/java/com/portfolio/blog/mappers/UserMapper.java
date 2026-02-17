package com.portfolio.blog.mappers;

import com.portfolio.blog.domain.dto.user.User;
import com.portfolio.blog.domain.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toDto(UserEntity entity);
    UserEntity toEntity(User userDto);
}
