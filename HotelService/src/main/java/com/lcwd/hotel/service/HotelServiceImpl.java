package com.lcwd.hotel.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.lcwd.hotel.HotelServiceApplication;
import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.repositories.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	private HotelRepository hotelRepository;

	// D.I via Constructor
	public HotelServiceImpl(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
		
	}

	@Override
	public Hotel registerHotel(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		Hotel save = hotelRepository.save(hotel);
		return save;
	}

	@Override
	public void deleteHotel(String hotelId) {
		Hotel hotel = hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel with givn id not found : " + hotelId));
		hotelRepository.delete(hotel);

	}

	@Override
	public Hotel updateHotel(Hotel hotel, String hotelId) {
		
		Hotel hotel2 = hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found"));
		hotel2.setName(hotel.getName());
		hotel2.setAbout(hotel.getAbout());
		hotel2.setLocation(hotel.getLocation());
		Hotel save = hotelRepository.save(hotel2);

		return save;
	}

	@Override
	public List<Hotel> getHotelList() {
		
		List<Hotel> listOfHotel = hotelRepository.findAll();
		return listOfHotel;
	}

}
