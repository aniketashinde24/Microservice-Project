package com.lcwd.rating.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.repositories.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingRepository ratingRepository;

	@Override
	public Rating create(Rating rating) {
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		Rating save = ratingRepository.save(rating);
		return save;
	}

	@Override
	public List<Rating> getRatings() {
		List<Rating> listOfRating = ratingRepository.findAll();
		return listOfRating;
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		List<Rating> byUserId = ratingRepository.findByUserId(userId);

		return byUserId;
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
