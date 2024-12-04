package com.bookStore.repository;

import com.bookStore.entity.Label;
import com.bookStore.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepo extends JpaRepository<Sample,Long> {
}
