package org.order.serviceimpl1;

import java.util.List;

import org.order.service.OrderDetails;
import org.order.service.OrderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.order.Order;
import org.order.OrderDao;





@Service
public class OrderServiceImpl1 implements OrderService {

	@Override
	public OrderDetails getOrder() {
		OrderDao orderDao=new OrderDao();
		//getAllOrder
		List<Order> orderList=orderDao.getAllOrder();
		OrderDetails<Order> orderDetails=new OrderDetails<Order>();
		orderDetails.setOrderList(orderList);
		return orderDetails;
	}

	@Override
	public OrderDetails saveOrder(OrderDetails orderDetails) {
		OrderDao orderDao=new OrderDao();
		orderDao.addOrder( orderDetails.getId() ,orderDetails.getScripName(), orderDetails.getPrice(), orderDetails.getQuantity(),orderDetails.getType());
		return orderDetails;
	}

}
