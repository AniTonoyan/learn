package org.simpleSpring.service;

import org.springframework.stereotype.Service;

@Service
public interface OrderService {

	public OrderDetails getOrder();
}
