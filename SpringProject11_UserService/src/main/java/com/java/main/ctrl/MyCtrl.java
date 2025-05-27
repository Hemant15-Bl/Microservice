package com.java.main.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.support.FeignHttpClientProperties.OkHttp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.main.entites.Employee;
import com.java.main.services.EmpService;
import com.java.main.services.EmpServiceImp;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class MyCtrl {
	
	@Autowired
	private EmpService empservice;
	
	private Logger logger = LoggerFactory.getLogger(MyCtrl.class);
	
	@PostMapping("/employee")
	public Employee addData(@RequestBody Employee emp) {
		return empservice.addEmp(emp);
		
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllData() {
		return empservice.getAllEmp();
		
	}
	
	int retrycount =1;
	
	@GetMapping("/employee/{id}")
	//@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
	//@Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "empRateLimiter",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<Employee> getData(@PathVariable String id) {
		logger.info("Retry-Count : {}", retrycount);
		retrycount++;
		Employee em = empservice.getEmp(id);
		if(em!=null) {
			return ResponseEntity.ok(em);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<Employee> ratingHotelFallback(String userid,Exception ex){
		logger.info("Fall back executed because service is down : ", ex.getMessage());
		Employee emp = Employee.builder()
				.name("dummy")
				.age(20)
				.salary(1000)
				.designation("No Service Is Available Because Service Is down!")
				.id("451263").build();
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
}
