package com.shoes.customer.service;

import com.shoes.customer.entity.Category;
import com.shoes.customer.repository.CategoryReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired private CategoryReponsitory repo;
    public void save(Category category) {
        repo.save(category);
    }

    public List<Category> listAll() {
        return (List<Category>) repo.findAll();
    }

    public Category get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
