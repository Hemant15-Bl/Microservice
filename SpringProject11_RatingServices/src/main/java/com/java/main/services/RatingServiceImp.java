package com.java.main.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.main.entities.Rating;
import com.java.main.repository.RatingRepository;

@Service
public class RatingServiceImp implements RatingService{
	
	@Autowired
	private RatingRepository ratrepository;
	
	@Override
	public Rating addRating(Rating rat) {
//		String rad = UUID.randomUUID().toString();
//		rat.setId(rad);
		return ratrepository.save(rat);
	}

	@Override
	public List<Rating> getRating() {
		// TODO Auto-generated method stub
		return ratrepository.findAll();
	}

	@Override
	public List<Rating> getEmpRating(String empid) {
		// TODO Auto-generated method stub
		return ratrepository.findByEmployeeId(empid);
	}

	@Override
	public List<Rating> getHotelRating(String hotelid) {
		// TODO Auto-generated method stub
		return ratrepository.findByHotelId(hotelid);
	}

}
