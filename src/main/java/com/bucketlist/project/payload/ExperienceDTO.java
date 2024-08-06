package com.bucketlist.project.payload;

import com.bucketlist.project.model.Category;

public class ExperienceDTO {
    private Long experienceId;
    private String experienceName;
    private Long categoryId;
    private String imgAddress;
    private String description;
    private Integer addedBy;

    public ExperienceDTO() {
    }

    public ExperienceDTO(Long experienceId, String experienceName, Long categoryId, String imgAddress, String description, Integer addedBy) {
        this.experienceId = experienceId;
        this.experienceName = experienceName;
        this.categoryId = categoryId;
        this.imgAddress = imgAddress;
        this.description = description;
        this.addedBy = addedBy;
    }

    public Long getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Long experienceId) {
        this.experienceId = experienceId;
    }

    public String getExperienceName() {
        return experienceName;
    }

    public void setExperienceName(String experienceName) {
        this.experienceName = experienceName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Integer addedBy) {
        this.addedBy = addedBy;
    }
}
