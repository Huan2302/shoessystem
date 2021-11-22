package com.shoes.customer.repository;

import com.shoes.customer.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryReponsitory extends CrudRepository<Category, Long> {
}
