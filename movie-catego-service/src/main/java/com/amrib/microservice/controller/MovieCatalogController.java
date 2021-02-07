package com.amrib.microservice.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amrib.microservice.models.CatalogItem;

@RestController
@RequestMapping(value = "/catalog")
public class MovieCatalogController {

	@GetMapping(value = "/{id}")
	public List<CatalogItem> getCatalog(@PathVariable(value = "id") String userId) {
		return Collections.singletonList(new CatalogItem("Avengers", "description", 7));
	}

}
