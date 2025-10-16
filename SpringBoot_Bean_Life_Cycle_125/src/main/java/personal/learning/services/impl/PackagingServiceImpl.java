package personal.learning.services.impl;

import org.springframework.stereotype.Service;

import personal.learning.dto.Order;
import personal.learning.services.PackagingService;

@Service
public class PackagingServiceImpl implements PackagingService {

	@Override
	public void packaging(Order order) {
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Order packaging completed... " + Thread.currentThread().getName());
	}

}
