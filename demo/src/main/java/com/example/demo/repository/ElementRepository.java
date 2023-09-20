package com.example.demo.repository;

import com.example.demo.model.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ElementRepository extends JpaRepository<Element, Long> {
    @Query(value = "SELECT * FROM element WHERE arr = :#{#arr_id} ORDER BY sorting", nativeQuery = true)
    List<Element> getAllByArr(@Param("arr_id")Long id);

    @Query(value = "SELECT max(e.arr) FROM element e", nativeQuery = true)
    public Long getMaxArr();

}
