package personal.learning.services.impl;

import org.springframework.stereotype.Service;

import personal.learning.services.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Override
	public boolean checkProductAvailability(int productId) {
		System.out.println("Product availability is checked... " + Thread.currentThread().getName());
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Product is available. " + Thread.currentThread().getName());
		return true;
	}
}
