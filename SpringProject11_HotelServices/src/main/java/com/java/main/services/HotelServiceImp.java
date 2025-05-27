package com.java.main.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.main.entities.Hotel;
import com.java.main.exception.ResourceNotFound;
import com.java.main.repository.HotelRepository;

@Service
public class HotelServiceImp implements HotelService{
	
	@Autowired
	private HotelRepository horepository;
	
	@Override
	public Hotel addhotel(Hotel hl) {
		String generateid = UUID.randomUUID().toString();
		hl.setId(generateid);
		return horepository.save(hl);
	}

	@Override
	public List<Hotel> getAllHote() {

		return horepository.findAll();
	}

	@Override
	public Hotel getHotel(String id) {
		// TODO Auto-generated method stub
		return horepository.findById(id).orElseThrow(() -> new ResourceNotFound("Hotel With Id Not Found !!"));
	}

}
