package com.shoes.customer.repository;

import com.shoes.customer.entity.Product_img;
import com.shoes.customer.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Product_imgReponsitory extends CrudRepository<Product_img,Long> {

    @Query(value = "select * from Product_img where productId = ?1", nativeQuery = true)
    List<Product_img> getAllByProductId(long id);

    @Modifying
    @Query(value = "delete from Product_img where productId = ?1", nativeQuery = true)
    void deleteProduct_imgByProductId(long id);
}
