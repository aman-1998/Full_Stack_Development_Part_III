package personal.learning.services.impl;

import org.springframework.stereotype.Service;

import personal.learning.dto.Order;
import personal.learning.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Override
	public void processPayment(Order order) {
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Processing payment... " + Thread.currentThread().getName());
	}
	
}
