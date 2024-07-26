package com.bucketlist.project.model;

public class Category {
    private Long categoryId;

    private String CategoryName;

    public Category(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        CategoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
