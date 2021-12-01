package com.shoes.customer.service;

import com.shoes.customer.entity.Oder;
import com.shoes.customer.entity.User;
import com.shoes.customer.repository.OderReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OderService {
    @Autowired
    private OderReponsitory repo; //DI

    public void save(Oder oder) {
        repo.save(oder);
    }

    public List<Oder> listAll() {
        return (List<Oder>) repo.findAll();
    }

    public Oder get(Long id) {
        return repo.findById(id).get();
    }

    public Oder findOderByUserId(Long id) {
        return repo.findOderByUserId(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Oder findOderByUser(User user){
        return repo.findOderByUser(user);
    }

    public void editTotal(float total,long id){
        repo.editTotal(total,id);
    }

    public void pay(long id){
        repo.pay(id);
    }

    public void handle(long id){
        repo.handle(id);
    }
}
