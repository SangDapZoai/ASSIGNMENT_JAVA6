package com.java6ASM.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="product")
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name ="product_id")
	private String id;
	
	@Column(name ="product_name")
	private String name;
	
	@Column(name ="product_img")
	private String img;
	
	@Column(name ="description")
	private String description;
	
	@Column(name ="qty")
	private int qty ;
	
	@Column(name ="price")
	private double price ;
	
	@Column(name ="discount")
	private double discount ;
	
	@Column(name ="sold_quantity")
	private int soidQuantity ;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	Category category;
	
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetails ;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	Brand brand;

}

