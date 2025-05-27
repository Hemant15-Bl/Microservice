package com.java.main.services;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.main.services.exception.ResourceNotFoundException;
import com.java.main.entites.Employee;
import com.java.main.entities.Hotel;
import com.java.main.entities.Rating;
import com.java.main.externalservices.HotelService;
import com.java.main.repository.EmpRepository;

@Service
public class EmpServiceImp implements EmpService{
	
	@Autowired
	private EmpRepository emprepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger = LoggerFactory.getLogger(EmpServiceImp.class);
	
	@Override
	public Employee addEmp(Employee emp) {
		String randomid = UUID.randomUUID().toString();
		emp.setId(randomid);
		return emprepository.save(emp);
	}

	@Override
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		List<Employee> emp = emprepository.findAll();
		
//		ArrayList forObj = restTemplate.getForObject("http://localhost:8083/ratings", ArrayList.class);
//		logger.info("{}", forObj);
//		 emp.setRating(forObj);
		return emp;
	}

	@Override
	public Employee getEmp(String id) {
		// TODO Auto-generated method stub
		Employee emp = emprepository.findById(id).orElseThrow((() -> new ResourceNotFoundException("Employee with given id "+id +" is not found on server!!")));

		Rating[] ratingOfEmployee = restTemplate.getForObject("http://RATING-SERVICE/ratings/employee/"+emp.getId(), Rating[].class);
		logger.info("{} ", ratingOfEmployee);
		
		List<Rating> ratings = Arrays.stream(ratingOfEmployee).toList();
		
		List<Rating> ratinglist = ratings.stream().map(rating -> {
			//http://localhost:8082/hotels/7578bd67-cfb8-4cea-88cc-56d630cf8bef
			//Rating rating = new Rating();
			//ResponseEntity<Hotel> forentity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//			Hotel hotel = forentity.getBody();
//			logger.info("response status code: ", forentity.getStatusCode());
			Hotel hotel = hotelService.gethotel(rating.getHotelId());
			
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		
		emp.setRating(ratinglist);
		return emp;
	}

}
