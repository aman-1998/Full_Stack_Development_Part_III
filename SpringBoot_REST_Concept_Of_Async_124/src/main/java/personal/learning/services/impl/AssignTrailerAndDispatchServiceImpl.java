package personal.learning.services.impl;

import org.springframework.stereotype.Service;

import personal.learning.dto.Order;
import personal.learning.services.AssignTrailerAndDispatchService;

@Service
public class AssignTrailerAndDispatchServiceImpl implements AssignTrailerAndDispatchService {

	@Override
	public void assignTrailerAndispatch(Order order) {
		try {
			Thread.sleep(4000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Trailer assigned and order dispatched... " + Thread.currentThread().getName());
	}

}
