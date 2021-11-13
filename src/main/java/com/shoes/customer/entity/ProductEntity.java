package com.shoes.customer.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String  productName;
    private float price;
    private String size;
    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "categoryId", nullable = false)
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "brandId", nullable = false)
    private BrandEntity brand;

    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE)
    private List<OderDetailEntity> oders = new ArrayList<>();

    public ProductEntity(int productId, String productName, float price, String size, String description, CategoryEntity category, BrandEntity brand, List<OderDetailEntity> oders) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.size = size;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.oders = oders;
    }

    public ProductEntity() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }

    public List<OderDetailEntity> getOders() {
        return oders;
    }

    public void setOders(List<OderDetailEntity> oders) {
        this.oders = oders;
    }
}
