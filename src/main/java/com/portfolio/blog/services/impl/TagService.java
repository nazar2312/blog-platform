package com.portfolio.blog.services.impl;

import com.portfolio.blog.domain.dto.post.PostRequest;
import com.portfolio.blog.domain.dto.tag.TagRequest;
import com.portfolio.blog.domain.dto.tag.TagResponse;
import com.portfolio.blog.domain.entities.TagEntity;
import com.portfolio.blog.mappers.TagMapper;
import com.portfolio.blog.repositories.TagRepository;
import com.portfolio.blog.services.TagServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TagService implements TagServiceInterface {

    private final TagRepository repository;
    private final TagMapper mapper;

    public TagResponse create(TagRequest request) {
        TagEntity entity = mapper.requestToEntity(request);
        return mapper.entityToResponse(repository.save(entity));
    }

    public List<TagResponse> findAll() {
        return repository.findAll().stream().map(
                        mapper::entityToResponse)
                .toList();
    }

    @Override
    public Set<TagEntity> verifyTags(PostRequest request) {
        /*
            Method finds all tags from request by their name and saves into new set;

            If size of the set is different from the request set, it means that used provided
            unexisting tags in the request.
         */
        Set<TagRequest> tagsFromRequest = request.getTags();
        List<String> nameOfTagsFromRequest = tagsFromRequest.stream()
                .map(TagRequest::getName)
                .toList();

        Set<TagEntity> tags = repository.findTagEntitiesByNameIn(nameOfTagsFromRequest);

        if(tags.size() != tagsFromRequest.size()) throw new IllegalArgumentException("Only existing tags can be assigned");

        return tags;
    }
}
