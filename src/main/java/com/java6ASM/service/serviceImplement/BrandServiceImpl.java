package com.java6ASM.service.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java6ASM.dto.BrandDTO;
import com.java6ASM.model.Brand;
import com.java6ASM.repository.BrandRepository;
import com.java6ASM.service.BrandService;



@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandRepository brandRepository;
	
	@Override
	public List<BrandDTO> findBrandByCategory(int idCategory) {
		return brandRepository.findBrandByCategory(idCategory);
	}

	@Override
	public List<Brand> findAllBrand() {
		return brandRepository.findAll();
	}

	@Override
	public Brand saveBrand(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public Brand findById(int idBrand) {
		return brandRepository.findById(idBrand).get();
	}

}
