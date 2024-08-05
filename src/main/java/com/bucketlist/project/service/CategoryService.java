package com.bucketlist.project.service;

import com.bucketlist.project.model.Category;
import com.bucketlist.project.payload.CategoryDTO;
import com.bucketlist.project.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getAllCategories();
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO deleteCategory(Long categoryId);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
