package com.example.demo.repositories;

import com.example.demo.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Query(value = "SELECT name FROM book", nativeQuery = true)
    Iterable<String> getBookNames();
}