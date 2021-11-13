package com.shoes.customer.entity;

import javax.persistence.*;

@Entity
public class OderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oserdId;
    private float unitPrice;
    private int quantity;
    private float total;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "productId", nullable = false)
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "oderId", nullable = false)
    private OderEntity oder;

    public OderDetailEntity(int oserdId, float unitPrice, int quantity, float total, ProductEntity product, OderEntity oder) {
        this.oserdId = oserdId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.total = total;
        this.product = product;
        this.oder = oder;
    }

    public OderDetailEntity() {
    }

    public int getOserdId() {
        return oserdId;
    }

    public void setOserdId(int oserdId) {
        this.oserdId = oserdId;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public OderEntity getOder() {
        return oder;
    }

    public void setOder(OderEntity oder) {
        this.oder = oder;
    }
}
