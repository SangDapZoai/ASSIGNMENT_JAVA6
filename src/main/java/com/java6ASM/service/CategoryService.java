package com.java6ASM.service;

import java.util.List;

import com.java6ASM.model.Category;



public interface CategoryService {
	
	List<Category> getAllCategory();
	
	void saveCategory(Category category);
	
	Category findById(int id);
}
