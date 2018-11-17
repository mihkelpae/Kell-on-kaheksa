package com.example.demo.repositories;

import com.example.demo.entities.IP;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

public interface IPRepository extends CrudRepository<IP, Long> {

    @Query(value="select location, count(location) as 'kogus' from ip where URI not like '%static%'\n" +
            "group by location\n" +
            "order by kogus desc\n" +
            "limit 1", nativeQuery = true)
    Map<String, Integer> findLocation();

    @Modifying
    @Transactional
    @Query(value="update ip set location=(:location) where ip=(:ip)", nativeQuery = true)
    void updateLocation(@Param("location") String location, @Param("ip") String ip);
}
