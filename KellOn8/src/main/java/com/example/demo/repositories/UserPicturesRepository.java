package com.example.demo.repositories;

import com.example.demo.entities.UserPictures;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserPicturesRepository extends CrudRepository<UserPictures, Long> {
    @Query(value="select data from user_pictures where owner=(:email)", nativeQuery = true)
    byte[] getByEmail(@Param("email")String email);

    @Query(value="select file_type from user_pictures where owner=(:email)", nativeQuery = true)
    String getTypeByEmail(@Param("email")String email);

    @Modifying
    @Transactional
    @Query(value="delete from user_pictures where owner=(:email)", nativeQuery = true)
    void deleteProfilePic(@Param("email")String email);
}
