package com.shoes.customer.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date oderDate;
    private int status;
    private float total;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @OneToMany(mappedBy = "oder", cascade = CascadeType.MERGE)
    private List<OderDetail> oders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOderDate() {
        return oderDate;
    }

    public void setOderDate(Date oderDate) {
        this.oderDate = oderDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OderDetail> getOders() {
        return oders;
    }

    public void setOders(List<OderDetail> oders) {
        this.oders = oders;
    }

    public Oder() {
    }

    public Oder(Long id, Date oderDate, int status, float total, User user, List<OderDetail> oders) {
        this.id = id;
        this.oderDate = oderDate;
        this.status = status;
        this.total = total;
        this.user = user;
        this.oders = oders;
    }
}
