package com.lcwd.hotel.service;

import java.util.List;

import com.lcwd.hotel.entities.Hotel;

public interface HotelService {

	public Hotel registerHotel(Hotel hotel);

	public void deleteHotel(String hotelId);

	public Hotel updateHotel(Hotel hotel, String hotelId);

	public List<Hotel> getHotelList();

}
