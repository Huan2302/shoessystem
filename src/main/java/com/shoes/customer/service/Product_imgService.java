package com.shoes.customer.service;

import com.shoes.customer.entity.Category;
import com.shoes.customer.entity.Product;
import com.shoes.customer.entity.Product_img;
import com.shoes.customer.repository.Product_imgReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Product_imgService {
    @Autowired private Product_imgReponsitory repo;
    public void save(Product_img product) {
        repo.save(product);
    }

    public List<Product_img> getAllByProductId(long id) {
        return (List<Product_img>) repo.getAllByProductId(id);
    }
}
