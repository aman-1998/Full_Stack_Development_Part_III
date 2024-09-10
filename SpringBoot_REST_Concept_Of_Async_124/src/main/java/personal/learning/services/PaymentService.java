package personal.learning.services;

import personal.learning.dto.Order;

public interface PaymentService {
	
	void processPayment(Order order);
}
