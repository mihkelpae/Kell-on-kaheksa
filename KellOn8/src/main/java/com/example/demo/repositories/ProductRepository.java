package com.example.demo.repositories;

import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    //Leia tooted kategooria järgi
    @Query(value="select * from products where category = :cat", nativeQuery = true)
    List<Product> findByCategory(@Param("cat") String category);

    //Leian kolm kõige kallimat toodet
    @Query(value="select * from products order by price desc limit 3", nativeQuery = true)
    List<Product> find3MostExpensive();

    //Leida toodete arv kategooria järgi
    @Query(value="select count(category) from products group by category", nativeQuery = true)
    List<Integer> countProductsByCategory(); //Siin peab olema midagi muud kui list<product>
    @Query(value="select category from products group by category", nativeQuery = true)
    List<String> showProductCategories();


}
