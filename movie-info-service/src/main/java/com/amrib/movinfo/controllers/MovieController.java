package com.amrib.movinfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.amrib.movinfo.models.Movie;
import com.amrib.movinfo.models.MovieSummary;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

//	@Value("${api.key}")
//	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/{id}")
	public Movie getMovies(@PathVariable(value = "id") String movieId) {
		MovieSummary movieSummary = restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=f7cf047297104cf1da0d1badb8f03233", MovieSummary.class);
		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
	}

}
