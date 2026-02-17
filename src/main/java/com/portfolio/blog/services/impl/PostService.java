package com.portfolio.blog.services.impl;

import com.portfolio.blog.domain.dto.post.PostRequest;
import com.portfolio.blog.domain.dto.post.PostResponse;
import com.portfolio.blog.domain.entities.CategoryEntity;
import com.portfolio.blog.domain.entities.PostEntity;
import com.portfolio.blog.mappers.PostMapper;
import com.portfolio.blog.repositories.PostRepository;
import com.portfolio.blog.services.CategoryServiceInterface;
import com.portfolio.blog.services.PostServiceInterface;
import com.portfolio.blog.services.UserServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService implements PostServiceInterface {

    private final PostRepository repository;
    private final PostMapper mapper;
    private final UserServiceInterface userService;
    private final CategoryServiceInterface categoryService;

    @Override
    public List<PostResponse> findAll() {

        List<PostResponse> posts = repository.findAll()
                .stream()
                .map(mapper::entityToResponse)
                .toList();

        if(posts.isEmpty()) throw new EntityNotFoundException("Posts are not found");

        return posts;
    }

    @Override
    public PostResponse findOne(UUID id) {

        Optional<PostEntity> post = repository.findById(id);

        if(post.isEmpty() ) throw new EntityNotFoundException("Post is not found");

        return mapper.entityToResponse(post.get());
    }

    @Override
    public PostResponse create(PostRequest request) {

        PostEntity postEntity = mapper.requestToEntity(request);

        postEntity.setAuthor(userService.extractUserFromSecurityContextHolder());

        postEntity.setReadingTime(postEntity.getContent().length() / 2);

        postEntity.setCategory(verifyCategory(request));


        return mapper.entityToResponse(repository.save(postEntity));
    }


    @Override
    public PostResponse update() {
        return null;
    }

    @Override
    public void delete() {

    }

    public void deleteAll() {
        repository.deleteAll();
    }


    private CategoryEntity verifyCategory(PostRequest request) {

        String name = request.getCategory().getName();
        if(name == null || name.isBlank()) throw new IllegalArgumentException("Please enter category name");

        return categoryService.findCategoryByName(name);
    }
}














