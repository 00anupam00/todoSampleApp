package com.rakshitlabs.springbootangulartodo.repository;


import com.rakshitlabs.springbootangulartodo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/* Spring Data Repository for fetching TODO lists */

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAll();

    List<Todo> findAllByUser(long userId);

}
