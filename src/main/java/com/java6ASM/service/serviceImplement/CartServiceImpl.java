package com.java6ASM.service.serviceImplement;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java6ASM.bean.SessionService;
import com.java6ASM.dto.CartDTO;
import com.java6ASM.model.Order;
import com.java6ASM.model.OrderDetail;
import com.java6ASM.model.Product;
import com.java6ASM.model.User;
import com.java6ASM.repository.OrderDetailRepository;
import com.java6ASM.repository.OrderRepository;
import com.java6ASM.repository.ProductRepository;
import com.java6ASM.service.CartService;



@Service
public class CartServiceImpl implements CartService {

	HashMap<String, CartDTO> cart = new HashMap<>();

	@Autowired
	ProductRepository productRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Autowired
	SessionService sessionService;

	@Override
	public void addCart(String idProduct) {
		if (cart.containsKey(idProduct)) {
			CartDTO cartDTO = cart.get(idProduct);
			cartDTO.setQty(cartDTO.getQty() + 1);
			cart.put(idProduct, cartDTO);
		} else {
			Product product = productRepository.findById(idProduct).get();
			CartDTO cartDTO = new CartDTO();
			if (product != null) {
				cartDTO.setId(product.getId());
				cartDTO.setName(product.getName());
				cartDTO.setImg(product.getImg());
				cartDTO.setPrice(product.getPrice());
				cartDTO.setQty(1);
				cart.put(idProduct, cartDTO);
			}
		}
	}

	@Override
	public Collection<CartDTO> getProduct() {
		return cart.values();
	}

	@Override
	public Double getAmount() {
		double total = 0;
		for (Map.Entry<String, CartDTO> entry : cart.entrySet()) {
			total += entry.getValue().getPrice() * entry.getValue().getQty();
		}
		return total;
	}

	@Override
	public int countCart() {
		int count = 0;
		for (Map.Entry<String, CartDTO> entry : cart.entrySet()) {
			count += entry.getValue().getQty();
		}
		return count;
	}

	@Override
	public void deleteAllProduct() {
		cart.clear();
	}

	@Override
	public void deleteProduct(String idProduct) {
		cart.remove(idProduct);
	}

	@Override
	public void sumQty(String idProduct, int qty) {
		CartDTO cartDTO = cart.get(idProduct);
		cartDTO.setQty(qty);
		cart.put(idProduct, cartDTO);
	}

	@Override
	public Long saveOrder(String province, String district, String country) {
		// inser vao bang order
		User userSession = sessionService.get("userss");
		User user = new User();
		user.setId(userSession.getId());
		Order order = new Order();
		Long id = (long) (orderRepository.selectMaxIdOrder() == null ? 1 : orderRepository.selectMaxIdOrder());
		order.setId(id);
		order.setDate(new Timestamp(System.currentTimeMillis()));
		order.setTotal(getAmount());
		order.setStatus("X");
		order.setUser(user);
		order.setProvince(province);
		order.setDistrict(district);
		order.setWard(country);
		orderRepository.save(order);

		// insert vao bang orderdetails
		for (Map.Entry<String, CartDTO> entry : cart.entrySet()) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setQuantity(entry.getValue().getQty());
			orderDetail.setPrice(entry.getValue().getPrice());
			orderDetail.setTotal(entry.getValue().getPrice() * entry.getValue().getQty());
			Product product = new Product();
			product.setId(entry.getKey());
			orderDetail.setProduct(product);
			order = new Order();
			order.setId(id);
			orderDetail.setOrder(order);
			orderDetailRepository.save(orderDetail);
		}
		deleteAllProduct();
		return id;
	}

}
