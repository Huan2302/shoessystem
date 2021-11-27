package com.shoes.customer.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  name;
    private float price;
    private String size;
    private int stock;
    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE)
    private List<Product_img> imgs = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "brandId", nullable = false)
    private Brand brand;

    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE)
    private List<OderDetail> oders = new ArrayList<>();

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product_img> getImgs() {
        return imgs;
    }

    public void setImgs(List<Product_img> imgs) {
        this.imgs = imgs;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<OderDetail> getOders() {
        return oders;
    }

    public void setOders(List<OderDetail> oders) {
        this.oders = oders;
    }

    public Product() {
    }

    public Product(Long id, String name, float price, String size, int stock, String description, List<Product_img> imgs, Category category, Brand brand, List<OderDetail> oders) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.stock = stock;
        this.description = description;
        this.imgs = imgs;
        this.category = category;
        this.brand = brand;
        this.oders = oders;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Product(Long id, String name, float price, String size, String description, List<Product_img> imgs, Category category, Brand brand, List<OderDetail> oders) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.description = description;
        this.imgs = imgs;
        this.category = category;
        this.brand = brand;
        this.oders = oders;
    }
}
