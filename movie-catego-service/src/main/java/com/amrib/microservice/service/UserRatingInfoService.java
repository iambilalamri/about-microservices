package com.amrib.microservice.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.amrib.microservice.models.Rating;
import com.amrib.microservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class UserRatingInfoService {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Here Hybrix gonna test last 5 request, if 50% of the request failed it break
	 * and each 5sec it ll test if the problem still till get response
	 * 
	 * @param userId
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "getFallbackUserRating", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000") })
	public UserRating getUserRating(@PathVariable(value = "id") String userId) {
		return restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);
	}

	public UserRating getFallbackUserRating(@PathVariable(value = "id") String userId) {
		UserRating rating = new UserRating();
		rating.setUserId(userId);
		rating.setUserRatings(Arrays.asList(new Rating("0", 0)));
		return rating;
	}

}
