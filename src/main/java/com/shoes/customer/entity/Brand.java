package com.shoes.customer.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.MERGE)
    private List<Product> brands = new ArrayList<>();

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

    public List<Product> getBrands() {
        return brands;
    }

    public void setBrands(List<Product> brands) {
        this.brands = brands;
    }

    public Brand() {
    }

    public Brand(Long id, String name, List<Product> brands) {
        this.id = id;
        this.name = name;
        this.brands = brands;
    }
}
