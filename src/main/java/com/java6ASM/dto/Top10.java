package com.java6ASM.dto;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import com.java6ASM.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Top10 implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	Product product;
	long sum;
}
