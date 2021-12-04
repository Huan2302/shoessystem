package com.shoes.customer.service;

import com.shoes.customer.entity.Product;
import com.shoes.customer.repository.ProductReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductReponsitory repo;
    public void save(Product product) {
        repo.save(product);
    }

    public List<Product> listAll() {
        return (List<Product>) repo.findAll();
    }

    public Product get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Product> getProductByCategoryId(long id){
        return repo.getProductByCategoryId(id);
    }
    public List<Product> getProductByBrandId(long id){
        return repo.getProductByBrandId(id);
    }

    public List<Product> search(String search){
        return (List<Product>) repo.search(search);
    }

    public List<Product> sortCatNameASC(long id){
        return repo.sortCatNameASC(id);
    }
    public List<Product> sortCatNameDESC(long id){
        return repo.sortCatNameDESC(id);
    }
    public List<Product> sortCatPriceASC(long id){
        return repo.sortCatPriceASC(id);
    }
    public List<Product> sortCatPriceDESC(long id){
        return repo.sortCatPriceDESC(id);
    }

    public List<Product> sortBrandNameASC(long id){
        return repo.sortBrandNameASC(id);
    }
    public List<Product> sortBrandNameDESC(long id){
        return repo.sortBrandNameDESC(id);
    }
    public List<Product> sortBrandPriceASC(long id){
        return repo.sortBrandPriceASC(id);
    }
    public List<Product> sortBrandPriceDESC(long id){
        return repo.sortBrandPriceDESC(id);
    }

}
