package com.study.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.hrpayroll.entities.Payment;
import com.study.hrpayroll.entities.Worker;
import com.study.hrpayroll.feingclients.WorkerFeingClients;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeingClients workerFeing;
	
	public Payment getPayment(Long workerId, Integer days) {
		Worker worker = workerFeing.findById(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
