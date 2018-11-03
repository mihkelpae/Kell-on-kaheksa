package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select * from users where email=(:email)", nativeQuery = true)
    User findByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "update users set address=:address where email=:email", nativeQuery = true)
    void updateAddress(@Param("address") String address, @Param("email") String email);
}