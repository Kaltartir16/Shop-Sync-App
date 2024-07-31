package com.esensesoftware.demo.repository;

import com.esensesoftware.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}//CategoryRepository
