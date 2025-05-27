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

import com.java.main.entities.Hotel;
import com.java.main.services.HotelService;

@RestController
public class MyController {
	
	@Autowired 
	private HotelService hoservice;
	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping("/hotels")
	public Hotel adddata(@RequestBody Hotel hl) {
		return hoservice.addhotel(hl);
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/hotels")
	public List<Hotel> getalldata() {
		return hoservice.getAllHote();
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("/hotels/{id}")
	public ResponseEntity<Hotel> getdata(@PathVariable String id) {
		Hotel ho = hoservice.getHotel(id);
		if(ho!=null) {
			return ResponseEntity.ok(ho);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
