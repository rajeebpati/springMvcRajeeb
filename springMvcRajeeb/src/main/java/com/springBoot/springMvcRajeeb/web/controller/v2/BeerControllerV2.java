package com.springBoot.springMvcRajeeb.web.controller.v2;

import java.util.UUID;

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

import com.springBoot.springMvcRajeeb.web.model.v2.BeerDtoV2;
import com.springBoot.springMvcRajeeb.web.services.v2.BeerServiceV2;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
private final BeerServiceV2 beerServiceV2;
	
	
	public BeerControllerV2(BeerServiceV2 beerServiceV2) {
		this.beerServiceV2 = beerServiceV2;
	}

	
	//Get Beer object
	@GetMapping({"/{beerId}"})
	public ResponseEntity<BeerDtoV2> getBeer (@PathVariable("beerId") UUID beerId) {
		//return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
		return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
		
	}

	//save Beer Object It is a create request
	
	@PostMapping
	public ResponseEntity<BeerDtoV2> postBeer(@RequestBody BeerDtoV2 beerDto) {
		BeerDtoV2 savedBeerDto = beerServiceV2.saveNewBeer(beerDto);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", "/api/v1/beer"+"/"+savedBeerDto.getId().toString());
		return new ResponseEntity<>(httpHeaders,HttpStatus.CREATED);
		
	}
	
	//Update the beeer object through Put request
	@PutMapping({"/{beerId}"})
	public ResponseEntity<BeerDtoV2> handlePut(@PathVariable ("beerId") UUID beerId,@RequestBody BeerDtoV2 beerDto) {
		beerServiceV2.updateBeer(beerId, beerDto); 	
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping({"/{beerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)// Doing this more appropiative if u r returning nothing than a message
	public void handleDelete(@PathVariable("beerId") UUID id ) {
		beerServiceV2.deleteBeer(id);
	}
}
