package com.bucketlist.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity (name = "experiences")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "experience_seq")
    @SequenceGenerator(name = "experience_seq", sequenceName = "experience_seq", allocationSize = 1)
    private Long experienceId;

    @NotBlank
    @Size(min = 3, message = "Experience name must contain at least three characters")
    private String experienceName;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "userId")
    private User createdBy;

    private String imgAddress;

    @NotBlank
    @Size(min = 3, message = "Experience description must contain at least three characters")
    private String description;

    @ManyToOne
    @JoinColumn(name = "last_modified_by", referencedColumnName = "userId")
    private User lastModifiedBy;

    public Experience() {
    }

    public Experience(Long experienceId, String experienceName, Category category, String imgAddress, String description, User createdBy, User lastModifiedBy) {
        this.experienceId = experienceId;
        this.experienceName = experienceName;
        this.category = category;
        this.imgAddress = imgAddress;
        this.description = description;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
    }


    public Long getExperienceIdId() {
        return experienceId;
    }

    public void setExperienceId(Long id) {
        this.experienceId = experienceId;
    }

    public String getExperienceName() {
        return experienceName;
    }

    public void setExperienceName(String experienceName) {
        this.experienceName = experienceName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
