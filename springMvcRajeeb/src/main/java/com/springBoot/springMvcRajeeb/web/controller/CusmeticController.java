package com.springBoot.springMvcRajeeb.web.controller;

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

import com.springBoot.springMvcRajeeb.web.model.CusmeticDto;
import com.springBoot.springMvcRajeeb.web.services.CusmeticService;

@RequestMapping("/api/v1/cusmetic")
@RestController
public class CusmeticController {

	private final CusmeticService cusmeticService;

	public CusmeticController(CusmeticService cusmeticService) {
		this.cusmeticService = cusmeticService;
	}
	
	@GetMapping({"/{cusmeticId}"})
	public ResponseEntity<CusmeticDto> getCusmetic(@PathVariable("cusmeticId") UUID cusmeticId) {
		
		return new ResponseEntity<>(cusmeticService.getCusmeticById(cusmeticId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CusmeticDto> handlePost(@RequestBody CusmeticDto cusmeticDto) {
		CusmeticDto createdCusmetic =  cusmeticService.createCusmetic(cusmeticDto);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", "/api/v1/cusmetic" + "/" +createdCusmetic.getId().toString());
		return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
	}
	
	@PutMapping({"/{cusmeticId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<CusmeticDto> handlePut(@RequestBody CusmeticDto cusmeticDto, @PathVariable("cusmeticId")  UUID cusmeticId) {
		 cusmeticService.updateCusmetic(cusmeticDto,cusmeticId );
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping({"/{cusmeticId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handleDelete(@PathVariable("cusmeticId") UUID cusmeticId) {
		cusmeticService.deleteCusmetic(cusmeticId);
	}
}
	
