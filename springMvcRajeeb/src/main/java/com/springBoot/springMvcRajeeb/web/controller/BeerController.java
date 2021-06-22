package com.springBoot.springMvcRajeeb.web.controller;

import java.util.UUID;

import org.apache.catalina.loader.ResourceEntry;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.springMvcRajeeb.web.model.BeerDto;
import com.springBoot.springMvcRajeeb.web.services.BeerService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	private final BeerService beerService;
	
	
	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}

	
	//Get Beer object
	@GetMapping({"/{beerId}"})
	public ResponseEntity<BeerDto> getBeer (@PathVariable("beerId") UUID beerId) {
		//return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
		
	}

	//save Beer Object It is a create request
	
	@PostMapping
	public ResponseEntity<BeerDto> postBeer(@RequestBody BeerDto beerDto) {
		BeerDto savedBeerDto = beerService.saveNewBeer(beerDto);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", "/api/v1/beer"+"/"+savedBeerDto.getId().toString());
		return new ResponseEntity<>(httpHeaders,HttpStatus.CREATED);
		
	}
	
	//Update the beeer object through Put request
	@PutMapping({"/{beerId}"})
	public ResponseEntity<BeerDto> handlePut(@PathVariable ("beerId") UUID beerId,@RequestBody BeerDto beerDto) {
		beerService.updateBeer(beerId, beerDto); 	
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping({"/{beerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)// Doing this more appropiative if u r returning nothing than a message
	public void handleDelete(@PathVariable("beerId") UUID id ) {
		beerService.deleteBeer(id);
	}
}
