package com.portfolio.blog.services.impl;

import com.portfolio.blog.domain.dto.category.Category;
import com.portfolio.blog.domain.dto.category.CategoryRequest;
import com.portfolio.blog.domain.entities.CategoryEntity;
import com.portfolio.blog.mappers.CategoryMapper;
import com.portfolio.blog.repositories.CategoryRepository;
import com.portfolio.blog.services.CategoryServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryServiceInterface {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public List<Category> findAllCategories() {

        List<CategoryEntity> categories = repository.findAll();

        if(categories.isEmpty()) throw new EntityNotFoundException();

        return categories.stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Category findCategoryById(UUID id) {

        Optional<CategoryEntity> category = repository.findById(id);
        
        if(category.isEmpty()) throw new EntityNotFoundException();
        
        return mapper.toDto(category.get());
    }

    @Override
    public Category createCategory(CategoryRequest category) {

        Category categoryDto = mapper.fromRequestToDto(category);
        CategoryEntity categoryEntity = repository.save(mapper.toEntity(categoryDto));

        return mapper.toDto(categoryEntity);

    }

    @Override
    public void deleteCategory(UUID toDelete) {

        repository.deleteById(toDelete);
    }

}
