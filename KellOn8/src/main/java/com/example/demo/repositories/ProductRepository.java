package com.example.demo.repositories;

import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value="select * from products where category = :cat", nativeQuery = true)
    List<Product> findByCategory(@Param("cat") String category);

    @Query(value="select * from products where category='Kuldkell'", nativeQuery = true)
    List<Product> find3MostExpensive();
}
