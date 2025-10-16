package personal.learning.services;

import personal.learning.dto.Order;

public interface OrderFulfillmentService {
	
	Order processOrder(Order order);
	
	void notifyUser(Order order);
	
	void assignVendor(Order order);
	
	void packaging(Order order);
	
	void assignDeliveryPartner(Order order);
	
	void assignTrailerAndDispatchService(Order order);
}
