package com.springBoot.springMvcRajeeb.web.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springBoot.springMvcRajeeb.web.model.BeerDto;


import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID beerId) {
		// TODO Auto-generated method stub
		
		return BeerDto.builder().id(beerId)
				.beerName("GalaxyCat")
				.beerStyle("Pale ale").build();
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		return BeerDto.builder().id(UUID.randomUUID()).build();		
	}

	@Override
	public void updateBeer(UUID beerId, BeerDto beerDto) {
		//TOdo Impl o updating Beer
		
	}

	@Override
	public void deleteBeer(UUID id) {
		// TODO Auto-generated method stub
		log.debug("Deleting Beer object ...");
	}

}
