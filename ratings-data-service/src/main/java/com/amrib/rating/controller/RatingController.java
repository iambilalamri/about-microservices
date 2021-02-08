package com.amrib.rating.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amrib.rating.model.Rating;
import com.amrib.rating.model.UserRating;

@RestController
@RequestMapping(value = "/ratingsdata")
public class RatingController {

	@GetMapping(value = "/{movieId}")
	public Rating getRating(@PathVariable(value = "movieId") String movieId) {
		return new Rating(movieId, 6);
	}

	@GetMapping(value = "/users/{userId}")
	public UserRating getUserRatings(@PathVariable(value = "userId") String userId) {
		List<Rating> ratings = Arrays.asList(new Rating("1234", 6), new Rating("5678", 8));
		UserRating userRating = new UserRating();
		userRating.setUserRatings(ratings);
		return userRating;
	}

}
