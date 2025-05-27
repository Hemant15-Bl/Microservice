package com.java.main.services;

import java.util.List;

import com.java.main.entities.Rating;

public interface RatingService {
	public Rating addRating(Rating rat);
	
	//get all rating
	public List<Rating> getRating();
	
	//get all rating by Employee Id
	public	List<Rating> getEmpRating(String empid);
	
		//get all rating by Hotel Id
	public	List<Rating> getHotelRating(String hotelid);
		
}
