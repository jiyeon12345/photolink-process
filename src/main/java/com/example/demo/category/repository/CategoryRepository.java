package com.example.demo.category.repository;

import com.example.demo.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {
    List<Category> findAllByOrderByIdDesc();
}
