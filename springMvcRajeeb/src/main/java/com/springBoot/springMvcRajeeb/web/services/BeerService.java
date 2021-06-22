package com.springBoot.springMvcRajeeb.web.services;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.springBoot.springMvcRajeeb.web.model.BeerDto;

public interface BeerService {

	BeerDto getBeerById(UUID beerId);

	BeerDto saveNewBeer(BeerDto beerDto);

	void updateBeer(UUID beerId, BeerDto beerDto);

	void deleteBeer(UUID id);

}
