package com.shoes.customer.repository;

import com.shoes.customer.entity.Brand;
import com.shoes.customer.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandReponsitory extends CrudRepository<Brand, Long> {
}
