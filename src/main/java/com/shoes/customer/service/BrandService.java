package com.shoes.customer.service;

import com.shoes.customer.entity.Brand;
import com.shoes.customer.entity.Category;
import com.shoes.customer.repository.BrandReponsitory;
import com.shoes.customer.repository.CategoryReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BrandService {
    @Autowired private BrandReponsitory repo; //DI IOC
    public void save(Brand brand) {
        repo.save(brand);
    }

    public List<Brand> listAll() {
        return (List<Brand>) repo.findAll();
    }

    public Brand get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
