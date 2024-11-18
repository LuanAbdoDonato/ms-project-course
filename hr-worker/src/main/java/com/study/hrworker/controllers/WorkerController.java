package com.study.hrworker.controllers;

import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.hrworker.entities.Worker;
import com.study.hrworker.repositories.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

	private static org.jboss.logging.Logger log = LoggerFactory.logger(WorkerController.class);

	@Value("${test.config}")
	private String testConfig;

	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repository;

	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfig(){
		log.info("CONFIG: " + testConfig);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> workers = repository.findAll();
		
		return ResponseEntity.ok(workers);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		log.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker worker = repository.findById(id).get();
		
		return ResponseEntity.ok(worker);
	}
}
