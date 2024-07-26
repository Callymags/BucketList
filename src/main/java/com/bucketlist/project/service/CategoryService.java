package com.bucketlist.project.service;

import com.bucketlist.project.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
}
