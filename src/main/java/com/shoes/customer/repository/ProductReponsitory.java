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

    @Query(value = "SELECT * FROM Product where name like %?1%",nativeQuery = true)
    List<Product> search(String search);

    @Query(value = "select * from Product where categoryId = ?1 order by name ASC", nativeQuery = true)
    List<Product> sortCatNameASC(long id);

    @Query(value = "select * from Product where categoryId = ?1 order by name DESC", nativeQuery = true)
    List<Product> sortCatNameDESC(long id);

    @Query(value = "select * from Product where categoryId = ?1 order by price ASC", nativeQuery = true)
    List<Product> sortCatPriceASC(long id);

    @Query(value = "select * from Product where categoryId = ?1 order by price DESC", nativeQuery = true)
    List<Product> sortCatPriceDESC(long id);

    @Query(value = "select * from Product where brandId = ?1 order by name ASC", nativeQuery = true)
    List<Product> sortBrandNameASC(long id);

    @Query(value = "select * from Product where brandId = ?1 order by name DESC", nativeQuery = true)
    List<Product> sortBrandNameDESC(long id);

    @Query(value = "select * from Product where brandId = ?1 order by price ASC", nativeQuery = true)
    List<Product> sortBrandPriceASC(long id);

    @Query(value = "select * from Product where brandId = ?1 order by price DESC", nativeQuery = true)
    List<Product> sortBrandPriceDESC(long id);


}
