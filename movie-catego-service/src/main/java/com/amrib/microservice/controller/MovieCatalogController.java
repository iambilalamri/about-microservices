package com.amrib.microservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.amrib.microservice.models.CatalogItem;
import com.amrib.microservice.models.Movie;
import com.amrib.microservice.models.Rating;
import com.amrib.microservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/catalog")
public class MovieCatalogController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientbuilder;

	@GetMapping(value = "/{id}")
	@HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public List<CatalogItem> getCatalog(@PathVariable(value = "id") String userId) {

		// List<Rating> ratings = Arrays.asList(new Rating("1234", 6), new
		// Rating("5678", 8)); ParameterizedTypeReference<ResponseWrapper<T>>(){}
		UserRating ratings = getUserRating(userId);
		/**
		 * RESTTEMPLATE TO CALL synchronously EXTERN SERVICE
		 */
		return ratings.getUserRatings().stream().map(rating -> getCatalogItem(ratings)).collect(Collectors.toList());
	}

	public List<CatalogItem> getFallbackCatalog(@PathVariable(value = "id") String userId) {
		return Arrays.asList(new CatalogItem("No Movie", "", 0))
	}

	private UserRating getUserRating(@PathVariable(value = "id") String userId) {
		return restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);
	}

	private CatalogItem getCatalogItem(Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movie/" + rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
	}

//	// @GetMapping(value = "/storage/in")
//	public List<CatalogItem> getCatalog2(@PathVariable(value = "id") String userId) {
//
//		List<Rating> ratings = Arrays.asList(new Rating("1234", 6), new Rating("5678", 8));
//
//		/**
//		 * WEBCLIENT TO CALL EXTERN SERVICE
//		 */
//		return ratings.stream().map(rating -> {
//			Movie movie = webClientbuilder.build().get().uri("http://localhost:8082/movie/" + rating.getMovieId())
//					.retrieve().bodyToMono(Movie.class).block();
//			return new CatalogItem(movie.getName(), "description", rating.getRating());
//		}).collect(Collectors.toList());
//
//		// return Collections.singletonList(new CatalogItem("Avengers",
//		// "description",7));
//	}

}
