package com.java.main.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.java.main.entities.Hotel;

@FeignClient("Hotel-Service")
public interface HotelService {
	
	@GetMapping("/hotels/{hotelid}")
	Hotel gethotel(@PathVariable String hotelid);
}
