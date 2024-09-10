package personal.learning.services.impl;

import org.springframework.stereotype.Service;

import personal.learning.dto.Order;
import personal.learning.services.AssigningVendor;

@Service
public class AssignVendorServiceImpl implements AssigningVendor {
	
	@Override
	public void assignVendor(Order order) {
		try {
			Thread.sleep(4000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Assign order to vendor... " + Thread.currentThread().getName());
	}
}
