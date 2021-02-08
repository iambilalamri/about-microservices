package com.amrib.microservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.amrib.microservice.models.CatalogItem;
import com.amrib.microservice.models.Movie;
import com.amrib.microservice.models.Rating;

@RestController
@RequestMapping(value = "/catalog")
public class MovieCatalogController {

	@GetMapping(value = "/{id}")
	public List<CatalogItem> getCatalog(@PathVariable(value = "id") String userId) {

		RestTemplate restTemplate = new RestTemplate();
		List<Rating> ratings = Arrays.asList(new Rating("1234", 6), new Rating("5678", 8));

		return ratings.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8082/movie/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), "description", rating.getRating());
		}).collect(Collectors.toList());

		// return Collections.singletonList(new CatalogItem("Avengers", "description",
		// 7));
	}

}
