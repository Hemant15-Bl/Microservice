package com.java.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.main.entities.Rating;
import java.util.List;


public interface RatingRepository extends JpaRepository<Rating, String>{
	List<Rating> findByEmployeeId(String employeeId);
	List<Rating> findByHotelId(String hotelId);
}
