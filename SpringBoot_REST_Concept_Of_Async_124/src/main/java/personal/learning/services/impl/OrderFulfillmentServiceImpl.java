package personal.learning.services.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import personal.learning.dto.Order;
import personal.learning.services.AssignDeliveryPartnerService;
import personal.learning.services.AssignTrailerAndDispatchService;
import personal.learning.services.AssigningVendor;
import personal.learning.services.InventoryService;
import personal.learning.services.NotificationService;
import personal.learning.services.OrderFulfillmentService;
import personal.learning.services.PackagingService;
import personal.learning.services.PaymentService;

@Service
public class OrderFulfillmentServiceImpl implements OrderFulfillmentService {
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private AssigningVendor assignVendor;
	
	@Autowired
	private PackagingService packagingService;
	
	@Autowired
	private AssignDeliveryPartnerService assignDeliveryPartnerService;
	
	@Autowired
	private AssignTrailerAndDispatchService assignTrailerAndDispatchService;
	
	@Override
	public Order processOrder(Order order) {
		order.setTrackingId(UUID.randomUUID().toString());
		if(inventoryService.checkProductAvailability(order.getProductId())) {
			paymentService.processPayment(order);
		} else {
			throw new RuntimeException("Technical issue please retry");
		}
		
		return order;
	}
	
	@Async("asyncTaskExecutor")
	@Override
	public void notifyUser(Order order) {
		notificationService.notifyUser(order);
	}
	
	@Async("asyncTaskExecutor")
	@Override
	public void assignVendor(Order order) {
		assignVendor.assignVendor(order);
	}
	
	@Async("asyncTaskExecutor")
	@Override
	public void packaging(Order order) {
		packagingService.packaging(order);
	}
	
	@Async("asyncTaskExecutor")
	@Override
	public void assignDeliveryPartner(Order order) {
		assignDeliveryPartnerService.assignDeliveryPartner(order);
	}
	
	@Async("asyncTaskExecutor")
	@Override
	public void assignTrailerAndDispatchService(Order order) {
		assignTrailerAndDispatchService.assignTrailerAndispatch(order);
	}
	
}
