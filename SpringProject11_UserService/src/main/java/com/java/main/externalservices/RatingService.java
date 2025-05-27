package com.java.main.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.java.main.entities.Rating;

@FeignClient("Rating-Service")
@Service
public interface RatingService {
	
	@PostMapping("/ratings")
	public Rating createRating(Rating rating);
	
	@PutMapping("/ratings/{ratingid}")
	public Rating updateRating(@PathVariable String ratingid, Rating rating);
	
	@DeleteMapping("/ratings/{ratingid}")
	public void deleteRating(@PathVariable String ratingid);
	

}
