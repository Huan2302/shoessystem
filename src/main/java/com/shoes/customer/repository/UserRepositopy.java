package com.shoes.customer.repository;

import com.shoes.customer.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositopy extends CrudRepository<User,Long> {
    @Query(value = "select * from User where email = ?1 and password = ?2", nativeQuery = true)
    User login(String email, String password);
}
