package com.shoes.customer.repository;

import com.shoes.customer.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositopy extends CrudRepository<User,Long> {
    @Query(value = "select * from User where email = ?1 and password = ?2", nativeQuery = true)
    User login(String email, String password);

    @Modifying
    @Query(value = "INSERT INTO User (email, password, userName,userType,phoneNumber,address) VALUES (?1,?2,?3,1,?4,?5)", nativeQuery = true)
    void register(String email, String password,String name,String phoneNumber,String address);

    @Modifying
    @Query(value = "update User set password = ?1, userName = ?3,phoneNumber = ?4,address = ?5 where id = ?2", nativeQuery = true)
    void editPasss(String pass ,long id,String name,String numberPhone,String address);
}
