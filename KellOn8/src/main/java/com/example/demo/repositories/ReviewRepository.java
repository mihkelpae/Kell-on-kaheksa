package com.example.demo.repositories;

import com.example.demo.entities.Review;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    @Modifying
    @Transactional
    @Query(value="insert into reviews (reply, author) values (:review, :author)", nativeQuery = true)
    void addReview(@Param("review") String review, @Param("author") String author);
}
