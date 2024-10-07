package com.bucketlist.project.payload;

public class ExperienceDTO {
    private Long experienceId;
    private String experienceName;
    private Long categoryId;
    private String imgAddress;
    private String description;
    private Long createdById;
    private Long lastModifiedById;

    public ExperienceDTO() {
    }

    public ExperienceDTO(Long experienceId, String experienceName, Long categoryId, String imgAddress, String description, Long createdById, Long lastModifiedById) {
        this.experienceId = experienceId;
        this.experienceName = experienceName;
        this.categoryId = categoryId;
        this.imgAddress = imgAddress;
        this.description = description;
        this.createdById = createdById;
        this.lastModifiedById = lastModifiedById;
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

    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

    public Long getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(Long lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }
}
