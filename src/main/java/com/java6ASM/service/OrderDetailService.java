package com.java6ASM.service;

import java.util.List;

import com.java6ASM.dto.OrderDetailDTO;
import com.java6ASM.dto.RevenueByCategory;
import com.java6ASM.dto.Top10;




public interface OrderDetailService {
	
	List<OrderDetailDTO> findByOrderDetailIdOrder(long idOrder);
	
	List<RevenueByCategory> RevenueByCategory();
	
	List<Top10> findAllProductTop10();
	
}
