package com.shoes.customer.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandId;
    private String brandName;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.MERGE)
    private List<ProductEntity> brands = new ArrayList<>();

    public BrandEntity() {
    }

    public BrandEntity(int brandId, String brandName, List<ProductEntity> brands) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brands = brands;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<ProductEntity> getBrands() {
        return brands;
    }

    public void setBrands(List<ProductEntity> brands) {
        this.brands = brands;
    }
}
