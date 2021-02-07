package com.amrib.movinfo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amrib.movinfo.models.Movie;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

	@GetMapping(value = "/{id}")
	public Movie getMovies(@PathVariable(value = "id") String movieId) {
		return new Movie(movieId, "Movie name");
	}

}
