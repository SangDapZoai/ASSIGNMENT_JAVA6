package com.java6ASM.service.serviceImplement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java6ASM.model.DeliveryAddress;
import com.java6ASM.repository.DeliveryAddressRepository;
import com.java6ASM.service.DeliveryAddressService;




@Service
public class DeliveryServiceImpl implements DeliveryAddressService{

	@Autowired
	DeliveryAddressRepository deliveryAddressRepository;

	@Override
	public DeliveryAddress findByIdDeliveryAddress(String idUser) {
		return deliveryAddressRepository.findByIdDeliveryAddress(idUser);
	}
	
}
