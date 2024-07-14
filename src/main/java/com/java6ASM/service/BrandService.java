package com.java6ASM.service;

import java.util.List;

import com.java6ASM.dto.BrandDTO;
import com.java6ASM.model.Brand;


public interface BrandService {
	
	List<BrandDTO> findBrandByCategory(int idCategory);
	
	List<Brand> findAllBrand();
	
	Brand saveBrand(Brand brand);
	
	Brand findById(int idBrand);
}
