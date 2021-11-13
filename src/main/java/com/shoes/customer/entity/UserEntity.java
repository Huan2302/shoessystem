package com.shoes.customer.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserId;

    private String userName;
    private String passWord;
    private String email;
    private String phoneNumber;
    private String Address;
    private int userType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
    private List<OderEntity> oders = new ArrayList<>();

    public UserEntity(int userId, String userName, String passWord, String email, String phoneNumber, String address, int userType, List<OderEntity> oders) {
        UserId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.phoneNumber = phoneNumber;
        Address = address;
        this.userType = userType;
        this.oders = oders;
    }

    public UserEntity() {
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public List<OderEntity> getOders() {
        return oders;
    }

    public void setOders(List<OderEntity> oders) {
        this.oders = oders;
    }
}
