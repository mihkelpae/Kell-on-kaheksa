package com.example.demo.repositories;

import com.example.demo.entities.Browser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface BrowserRepository extends CrudRepository<Browser, Long> {

    @Query(value="select browser, count(browser) as 'kogus' from browser where URI not like '%static%'\n" +
            "group by browser\n" +
            "order by kogus desc\n" +
            "limit 1", nativeQuery = true)
    Map<String, Integer> findBrowsers();
}
