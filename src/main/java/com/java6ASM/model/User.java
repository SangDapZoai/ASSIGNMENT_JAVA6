package com.java6ASM.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	private String id;
	
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private boolean role ;;
	
	@Column(name = "is_Active")
	private boolean isActive ;;
	
	@Column(name = "code")
	private String code;
	
	@OneToMany(mappedBy = "user")
	List<DeliveryAddress> deliveryAddresses;
	
	@OneToMany(mappedBy = "user")
	List<Order> orders;
}
