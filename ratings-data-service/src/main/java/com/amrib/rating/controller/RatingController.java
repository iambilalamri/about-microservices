package com.amrib.rating.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amrib.rating.model.Rating;

@RestController
@RequestMapping(value = "/ratingsdata")
public class RatingController {

	@GetMapping(value = "/{movieId}")
	public Rating getRating(@PathVariable(value = "movieId") String movieId) {
		return new Rating(movieId, 6);
	}

}
