package com.example.demo.repositories;

import com.example.demo.entities.OS;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Map;

public interface OSRepository extends CrudRepository<OS, Long> {

    @Query(value="select opsys, count(opsys) as 'kogus' from os where URI not like '%static%'\n" +
            "group by opsys\n" +
            "order by kogus desc\n" +
            "limit 1", nativeQuery = true)
    Map<String, Integer> findOpSys();

    @Query(value="select URI, count(URI) as 'kogus' from os where URI not like '%static%'\n" +
            "group by URI\n" +
            "order by kogus desc limit 1", nativeQuery = true)
    Map<String, Integer> findMostVisitedPage();
}
