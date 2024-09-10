package personal.learning.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import personal.learning.dto.Order;
import personal.learning.services.OrderFulfillmentService;

@RestController
public class OrderFulfillmentController {
	
	private OrderFulfillmentService orderFulfillmentService;
	
	public OrderFulfillmentController(OrderFulfillmentService orderFulfillmentService) {
		this.orderFulfillmentService = orderFulfillmentService;
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.POST, 
					consumes = MediaType.APPLICATION_JSON_VALUE, 
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Order> checkStatus(@RequestBody Order order) {
		//synchronous
		orderFulfillmentService.processOrder(order);
		
		//asynchronous
		orderFulfillmentService.notifyUser(order);
		orderFulfillmentService.assignVendor(order);
		orderFulfillmentService.packaging(order);
		orderFulfillmentService.assignDeliveryPartner(order);
		orderFulfillmentService.assignTrailerAndDispatchService(order);
		
		return ResponseEntity.ok(order);
	}
	
}
