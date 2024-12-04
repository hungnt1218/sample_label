package com.bookStore.repository;

import com.bookStore.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelRepo extends JpaRepository<Label,Long> {
    @Query(value = "SELECT * FROM label where name like %:name%", nativeQuery = true)
    List<Label> getByUsername(String name);
}
