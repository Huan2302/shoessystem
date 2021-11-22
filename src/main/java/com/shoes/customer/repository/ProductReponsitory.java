package com.shoes.customer.repository;

import com.shoes.customer.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductReponsitory extends CrudRepository<Product,Long> {
}
