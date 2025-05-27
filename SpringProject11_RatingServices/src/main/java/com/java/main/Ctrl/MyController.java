package com.java.main.Ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.main.entities.Rating;
import com.java.main.services.RatingService;

@RestController
public class MyController {
		
	@Autowired
	private RatingService ratservice;
	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping("/ratings")
	public Rating addData(@RequestBody Rating rat) {
		return ratservice.addRating(rat);
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/ratings")
	public ResponseEntity<List<Rating>> getAllData() {
		return ResponseEntity.ok(ratservice.getRating());
	}
	
	@GetMapping("/ratings/employee/{empid}")
	public ResponseEntity<List<Rating>> getempData(@PathVariable String empid) {
		return ResponseEntity.ok(ratservice.getEmpRating(empid));
	}
	
	@GetMapping("/ratings/hotels/{hotelid}")
	public ResponseEntity<List<Rating>> gethotelData(@PathVariable String hotelid) {
		return ResponseEntity.ok(ratservice.getHotelRating(hotelid));
	}
}
