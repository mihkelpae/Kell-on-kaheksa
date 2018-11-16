package com.example.demo.repositories;

import com.example.demo.entities.OS;
import org.springframework.data.repository.CrudRepository;

public interface OSRepository extends CrudRepository<OS, Long> {
}
