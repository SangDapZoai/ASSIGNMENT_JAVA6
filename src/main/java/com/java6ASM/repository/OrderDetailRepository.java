package com.java6ASM.repository;

import java.util.List;

//import org.hibernate.transform.ResultTransformer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java6ASM.dto.OrderDetailDTO;
import com.java6ASM.dto.Top10;
import com.java6ASM.model.OrderDetail;
import com.java6ASM.dto.RevenueByCategory;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

//	@Query("select o from OrderDetail o where o.order.id=:idorder ")
//	List<OrderDetail> findByOrderDetailIdOrder(@Param("idorder") long idOrder);	
	
	@Query("select new OrderDetailDTO(o.id,o.product.name, o.product.img, o.product.price, o.quantity, o.total, o.order.province,  o.order.district,  o.order.ward  ) from OrderDetail o where o.order.id=:idorder")
	List<OrderDetailDTO> findByOrderDetailIdOrder(@Param("idorder") long idOrder); 
	
	@Query("select new RevenueByCategory(d.product.category.name, sum(d.price*d.quantity), sum(d.quantity)) from OrderDetail d group by d.product.category.name")
	List<RevenueByCategory> RevenueByCategory();
	
	@Query("SELECT new Top10(o.product, sum(o.quantity)) FROM OrderDetail o GROUP BY o.product ORDER BY sum(o.quantity) DESC ")
	List<Top10> getTop10();
}
