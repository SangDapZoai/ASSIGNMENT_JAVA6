package com.java6ASM.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="Orders")
public class Order implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Order_id")
	private long id;
	
	@Column(name="Order_date")
	@Temporal(TemporalType.DATE)
	private Date date = new Date();
	
	@Column(name="total")
	private double total;
	
//	X: Dang xu li, N: Da nhan hang, H:Huy
	@Column(name="status")
	private String status;
	
	@Column(name="province")
	private String province;
	
	@Column(name="district")
	private String district;
	
	@Column(name="ward")
	private String ward;
	
	@OneToMany(mappedBy = "order")
	List<OrderDetail> orderDetails;
	
	@ManyToOne
	@JoinColumn(name="user_id ")
	User user;
}
