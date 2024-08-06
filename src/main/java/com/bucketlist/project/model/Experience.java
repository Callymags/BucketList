package com.bucketlist.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity (name = "experiences")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "experience_seq")
    @SequenceGenerator(name = "experience_seq", sequenceName = "experience_seq", allocationSize = 1)
    private Long id;

    @NotBlank
    @Size(min = 3, message = "Experience name must contain at least three characters")
    private String experienceName;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
    private Category category;

    private String imgAddress;

    private String description;

    private Integer addedBy;

    public Experience() {
    }

    public Experience(Long id, String experienceName, Category category, String imgAddress, String description, Integer addedBy) {
        this.id = id;
        this.experienceName = experienceName;
        this.category = category;
        this.imgAddress = imgAddress;
        this.description = description;
        this.addedBy = addedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Integer addedBy) {
        this.addedBy = addedBy;
    }
}
