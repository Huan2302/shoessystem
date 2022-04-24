package com.shoes.customer.service;

import com.shoes.customer.entity.User;
import com.shoes.customer.repository.UserRepositopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepositopy repo;
    public void save(User user) {
        repo.save(user);
    }

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public User get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public User login(String email, String password) {
        return repo.login(email, password);
    }

    public void register(String email,String pass,String name,String phoneNumber, String address) {
        repo.register(email,pass,name,phoneNumber,address);
    }

    public void editPass(String pass,long id,String name,String numberPhone,String address) {
        repo.editPasss(pass,id,name,numberPhone,address);
    }
}
