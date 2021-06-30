package com.example.demo.repository;

import com.example.demo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, String> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE todo SET done = 1 WHERE id = :id ", nativeQuery = true)
    void updateCheckDoneById(@Param("id") String id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE todo SET done = 0 WHERE id = :id ", nativeQuery = true)
    void updateCheckUnDoneById(@Param("id") String id);
}
