package com.portfolio.blog.services;

import com.portfolio.blog.domain.dto.category.Category;
import com.portfolio.blog.domain.dto.category.CategoryRequest;

import java.util.List;
import java.util.UUID;

public interface CategoryServiceInterface {

     List<Category> findAllCategories();
     Category findCategoryById(UUID id);
     Category createCategory(CategoryRequest category);
     void deleteCategory(UUID toDelete);

}
