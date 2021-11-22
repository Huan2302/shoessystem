package com.shoes.customer.repository;

import com.shoes.customer.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositopy extends CrudRepository<User,Long> {
}
