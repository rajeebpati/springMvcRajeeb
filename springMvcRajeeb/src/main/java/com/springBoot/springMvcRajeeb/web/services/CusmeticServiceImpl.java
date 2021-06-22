package com.springBoot.springMvcRajeeb.web.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springBoot.springMvcRajeeb.web.model.CusmeticDto;

@Service
public class CusmeticServiceImpl implements CusmeticService {

	@Override
	public CusmeticDto getCusmeticById(UUID cusmeticId) {

		//Create a new object and initialize oject with new value otherwsie use lombok
		//It asks cusmeticDto oject
		return CusmeticDto.builder().id(cusmeticId).name("Cusmetic product Name").build();
	}

	@Override
	public CusmeticDto createCusmetic(CusmeticDto cusmeticDto) {
		return CusmeticDto.builder().id(UUID.randomUUID()).name("cusmetic powder").build();
	}

	@Override
	public CusmeticDto updateCusmetic(CusmeticDto cusmeticDto, UUID cusmeticId) {
		
		 return CusmeticDto.builder().id(cusmeticId).name(cusmeticDto.getName()).build();
		 //Todo Update logic
	}

	@Override
	public void deleteCusmetic(UUID cusmeticId) {
		// TODO Auto-generated method stub
		// todo write delete object
		
	}




}
