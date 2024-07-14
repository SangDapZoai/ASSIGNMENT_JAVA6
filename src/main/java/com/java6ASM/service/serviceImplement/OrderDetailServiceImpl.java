package com.java6ASM.service.serviceImplement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java6ASM.dto.OrderDetailDTO;
import com.java6ASM.dto.RevenueByCategory;
import com.java6ASM.dto.Top10;
import com.java6ASM.repository.OrderDetailRepository;
import com.java6ASM.service.OrderDetailService;



@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Override
	public List<OrderDetailDTO> findByOrderDetailIdOrder(long idOrder) {
		return orderDetailRepository.findByOrderDetailIdOrder(idOrder);
	}

	@Override
	public List<RevenueByCategory> RevenueByCategory() {
		return orderDetailRepository.RevenueByCategory();
	}

	@Override
	public List<Top10> findAllProductTop10() {
		List<Top10> listTop10 = new ArrayList<>();
		int count = 0;
		for (Top10 list : orderDetailRepository.getTop10()) {
			if (count > 10) {
				break;
			}			
			listTop10.add(list);
			count++;
		}
		return listTop10;
	}
}
