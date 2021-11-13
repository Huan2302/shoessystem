package com.shoes.customer.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class OderEntity {
    @Id
    private int oderid;
    private Date oderDate;
    private int status;
    private float total;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "oder", cascade = CascadeType.MERGE)
    private List<OderDetailEntity> oders = new ArrayList<>();

    public OderEntity(int oderid, Date oderDate, int status, float total, UserEntity user, List<OderDetailEntity> oders) {
        this.oderid = oderid;
        this.oderDate = oderDate;
        this.status = status;
        this.total = total;
        this.user = user;
        this.oders = oders;
    }

    public OderEntity() {
    }

    public int getOderid() {
        return oderid;
    }

    public void setOderid(int oderid) {
        this.oderid = oderid;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<OderDetailEntity> getOders() {
        return oders;
    }

    public void setOders(List<OderDetailEntity> oders) {
        this.oders = oders;
    }
}
