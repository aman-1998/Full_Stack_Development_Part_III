package personal.learning.services.impl;

import org.springframework.stereotype.Service;

import personal.learning.dto.Order;
import personal.learning.services.AssignDeliveryPartnerService;

@Service
public class AssignDeliveryPartnerServiceImpl implements AssignDeliveryPartnerService {

	@Override
	public void assignDeliveryPartner(Order order) {
		try {
			Thread.sleep(6000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Delivery partner assigned... " + Thread.currentThread().getName());
	}
	
}
