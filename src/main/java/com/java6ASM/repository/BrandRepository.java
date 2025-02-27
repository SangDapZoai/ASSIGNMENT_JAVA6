package com.java6ASM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java6ASM.dto.BrandDTO;
import com.java6ASM.model.Brand;




@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
//	 @Query("SELECT p FROM Product p JOIN p.brand b WHERE b.id = :brandId")
	@Query("select DISTINCT new BrandDTO(b.id, b.name, b.img) from Brand b JOIN b.product p where p.category.id=:id")
	List<BrandDTO> findBrandByCategory(@Param("id") int idCategory);

}
