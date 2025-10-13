package com.lcwd.hotel.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	private HotelService hotelService;

	public HotelController(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	@PostMapping("/")
	public ResponseEntity<Hotel> registerHotel(@RequestBody Hotel hotel) {

		Hotel registerHotel = hotelService.registerHotel(hotel);
		return new ResponseEntity<Hotel>(registerHotel, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteHotel(@PathVariable String id) {

		hotelService.deleteHotel(id);

		return "Hotel with hotel id : " + id + "deleted successfull .";
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel, @PathVariable String id) {
		Hotel updateHotel = hotelService.updateHotel(hotel, id);
		return new ResponseEntity<Hotel>(updateHotel, HttpStatus.OK);

	}
	
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getAllHotels(){
		
		List<Hotel> hotelList = hotelService.getHotelList();
		
		return new ResponseEntity<List<Hotel>>(hotelList,HttpStatus.OK);
	}

}
