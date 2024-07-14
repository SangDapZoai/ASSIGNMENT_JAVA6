package com.java6ASM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java6ASM.model.Category;




@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	
}
