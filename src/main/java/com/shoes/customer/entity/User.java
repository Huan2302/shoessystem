package com.shoes.customer.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    private int userType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    private List<Oder> oders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public List<Oder> getOders() {
        return oders;
    }

    public void setOders(List<Oder> oders) {
        this.oders = oders;
    }

    public User() {
    }

    public User(Long id, String userName, String password, String email, String phoneNumber, String address, int userType, List<Oder> oders) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userType = userType;
        this.oders = oders;
    }
}
