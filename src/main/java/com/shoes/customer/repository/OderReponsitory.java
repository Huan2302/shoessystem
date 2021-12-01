package com.shoes.customer.repository;

import com.shoes.customer.entity.Oder;
import com.shoes.customer.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OderReponsitory extends CrudRepository<Oder,Long> {
    @Query(value = "select * from Oder where userId = ?1 and status = 0", nativeQuery = true)
    Oder findOderByUserId(long id);

    public Oder findOderByUser(User user);

    @Modifying
    @Query(value = "update Oder set total = ?1 where id = ?2", nativeQuery = true)
    void editTotal(float total,long id);

    @Modifying
    @Query(value = "update Oder set status = 1 where id = ?1", nativeQuery = true)
    void pay(long id);

    @Modifying
    @Query(value = "update Oder set status = 2 where id = ?1 and status = 1", nativeQuery = true)
    void handle(long id);

}
