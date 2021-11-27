package com.shoes.customer.repository;

import com.shoes.customer.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductReponsitory extends CrudRepository<Product,Long> {

    @Query(value = "select * from Product where categoryId = ?1", nativeQuery = true)
    List<Product> getProductByCategoryId(long id);

    @Query(value = "select * from Product where brandId = ?1", nativeQuery = true)
    List<Product> getProductByBrandId(long id);
}
