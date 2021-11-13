package com.shoes.customer.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CategoryId;
    private String CategoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.MERGE)
    private List<ProductEntity> categorys = new ArrayList<>();

    public CategoryEntity() {
    }

    public CategoryEntity(int categoryId, String categoryName, List<ProductEntity> categorys) {
        CategoryId = categoryId;
        CategoryName = categoryName;
        this.categorys = categorys;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public List<ProductEntity> getArticles() {
        return categorys;
    }

    public void setArticles(List<ProductEntity> categorys) {
        this.categorys = categorys;
    }
}
