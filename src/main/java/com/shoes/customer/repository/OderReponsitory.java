package com.shoes.customer.repository;

import com.shoes.customer.entity.Oder;
import com.shoes.customer.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OderReponsitory extends CrudRepository<Oder,Long> {
    @Query(value = "select * from Oder where userId = ?1", nativeQuery = true)
    Oder findOderByUserId(long id);

    public Oder findOderByUser(User user);

}
