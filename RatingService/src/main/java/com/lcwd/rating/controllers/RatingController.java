package com.lcwd.rating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	// create rating
	@Autowired
	private RatingService ratingService;

	@PostMapping("/")
	public ResponseEntity<Rating> create(@RequestBody Rating rating) {
		Rating rating2 = ratingService.create(rating);
		return new ResponseEntity<Rating>(rating2, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<Rating>> getRatings() {
		List<Rating> ratings = ratingService.getRatings();
		return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
	}

	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
		List<Rating> ratingByHotelId = ratingService.getRatingByHotelId(hotelId);
		return new ResponseEntity<List<Rating>>(ratingByHotelId, HttpStatus.OK);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
		List<Rating> ratingByUserId = ratingService.getRatingByUserId(userId);
		return new ResponseEntity<List<Rating>>(ratingByUserId, HttpStatus.OK);
	}

}
