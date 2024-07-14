package com.java6ASM.service.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java6ASM.model.Category;
import com.java6ASM.repository.CategoryRepository;
import com.java6ASM.service.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategory() {	
		return categoryRepository.findAll() ;
	}

	@Override
	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public Category findById(int id) {
		return categoryRepository.findById(id).get();
	}

}
