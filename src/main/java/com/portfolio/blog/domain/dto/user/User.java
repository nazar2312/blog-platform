package com.portfolio.blog.domain.dto.user;

import java.util.UUID;

public record User(
        UUID id,
        String username,
        String email
) {
}
