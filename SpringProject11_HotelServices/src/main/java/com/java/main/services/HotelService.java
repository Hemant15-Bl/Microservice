package com.java.main.services;

import java.util.List;

import com.java.main.entities.Hotel;

public interface HotelService {
	public Hotel addhotel(Hotel hl);
	public List<Hotel> getAllHote();
	public Hotel getHotel(String id);
}
