package com.example.demo.repositories;

import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    //Leia tooted kategooria järgi
    @Query(value="select * from products where category = (:cat)", nativeQuery = true)
    List<Product> findByCategory(@Param("cat") String cat);

    //Leian kolm kõige kallimat toodet
    @Query(value="select * from products order by price desc limit 3", nativeQuery = true)
    List<Product> find3MostExpensive();

    //Leida toodete arv kategooria järgi
    @Query(value="select count(category) from products group by category", nativeQuery = true)
    List<Integer> countProductsByCategory(); //Siin peab olema midagi muud kui list<product>
    @Query(value="select category from products group by category", nativeQuery = true)
    List<String> showProductCategories();

    //Leian unikaalsete toodete arvu
    @Query(value="select count(id) from products", nativeQuery = true)
    Integer countOfUniqueProducts();

    //Leain kogu toodete arvu
    @Query(value="select sum(quantity) from products", nativeQuery = true)
    Integer countOfAllProducts();

    //Leian kõik tooted
    @Query(value="select * from products", nativeQuery=true)
    List<Product> findAll();

}
