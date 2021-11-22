package com.shoes.customer.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.MERGE)
    private List<Product> categorys = new ArrayList<>();

    public Category() {
    }

    public Category(Long categoryId, String categoryName, List<Product> categorys) {
        id = categoryId;
        name = categoryName;
        this.categorys = categorys;
    }

    public List<Product> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<Product> categorys) {
        this.categorys = categorys;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getArticles() {
        return categorys;
    }

    public void setArticles(List<Product> categorys) {
        this.categorys = categorys;
    }
}
