package com.shoes.customer.repository;

import com.shoes.customer.entity.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandReponsitory extends CrudRepository<Brand, Long> {
    //DAO
}
