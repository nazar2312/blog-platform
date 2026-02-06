package com.portfolio.blog.services;

import com.portfolio.blog.domain.dto.Category;
import com.portfolio.blog.domain.dto.CreateCategoryRequest;

import java.util.List;
import java.util.UUID;

public interface CategoryServiceInterface {

     List<Category> findAllCategories();
     Category findCategoryById(UUID id);
     Category createCategory(CreateCategoryRequest category);
     void deleteCategory(UUID toDelete);

}
