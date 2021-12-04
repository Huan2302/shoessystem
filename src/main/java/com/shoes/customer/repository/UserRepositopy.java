package com.shoes.customer.repository;

import com.shoes.customer.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositopy extends CrudRepository<User,Long> {
    @Query(value = "select * from User where email = ?1 and password = ?2", nativeQuery = true)
    User login(String email, String password);

    @Modifying
    @Query(value = "INSERT INTO User (email, password, userName,userType) VALUES (?1,?2,?3,1)", nativeQuery = true)
    void register(String email, String password,String name);

    @Modifying
    @Query(value = "update User set password = ?1 where id = ?2", nativeQuery = true)
    void editPasss(String pass ,long id);
}
