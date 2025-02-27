package com.java6ASM.dto;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RevenueByCategory implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String categoryName;
	
    private double totalRevenue;
    
    private long totalQuantity;

//    public RevenueByCategory(String categoryName, double totalRevenue, long totalQuantity) {
//        this.categoryName = categoryName;
//        this.totalRevenue = totalRevenue;
//        this.totalQuantity = totalQuantity;
//    }

}

