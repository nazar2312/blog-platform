package com.portfolio.blog.services.impl;

import com.portfolio.blog.domain.dto.post.PostRequest;
import com.portfolio.blog.domain.dto.post.PostResponse;
import com.portfolio.blog.domain.entities.CategoryEntity;
import com.portfolio.blog.domain.entities.PostEntity;
import com.portfolio.blog.domain.entities.UserEntity;
import com.portfolio.blog.mappers.PostMapper;
import com.portfolio.blog.repositories.CategoryRepository;
import com.portfolio.blog.repositories.PostRepository;
import com.portfolio.blog.repositories.UserRepository;
import com.portfolio.blog.services.PostServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class PostService implements PostServiceInterface {

    private final PostRepository repository;
    private final PostMapper mapper;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

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
    @Transactional
    public PostResponse create(PostRequest request) {

        String categoryName = request.getCategory().getName();

        PostEntity post = mapper.requestToEntity(request);

        post.setAuthor(extractUserFromSecurityContext());
        verifyCategory(post, categoryName);

        System.out.println(post.getCategory());

        return mapper.entityToResponse(repository.save(post));
    }

    @Override
    public PostResponse update() {
        return null;
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private UserEntity extractUserFromSecurityContext() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<UserEntity> user = userRepository.findByEmail(email);

        if(user.isEmpty()) throw new EntityNotFoundException("Failed to find user while extracting from Security context");
        else return user.get();
    }

    private void verifyCategory(PostEntity post, String categoryName) {
        CategoryEntity category =  categoryRepository.findByName(categoryName).get();
        post.setCategory(category);
    }



}














