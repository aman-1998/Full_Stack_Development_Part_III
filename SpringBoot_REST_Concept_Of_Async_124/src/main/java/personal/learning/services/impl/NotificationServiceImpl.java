package personal.learning.services.impl;

import org.springframework.stereotype.Service;

import personal.learning.dto.Order;
import personal.learning.services.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Override
	public void notifyUser(Order order) {
		try {
			Thread.sleep(4000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Notified to the user... " + Thread.currentThread().getName());
	}

}
