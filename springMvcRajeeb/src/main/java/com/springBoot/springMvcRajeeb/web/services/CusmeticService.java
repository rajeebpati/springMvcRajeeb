package com.springBoot.springMvcRajeeb.web.services;

import java.util.UUID;

import com.springBoot.springMvcRajeeb.web.model.CusmeticDto;

public interface CusmeticService {

	CusmeticDto getCusmeticById(UUID cusmeticId);

	//CusmeticDto updateCusmetic(CusmeticDto cusmeticDto);

	CusmeticDto createCusmetic(CusmeticDto cusmeticDto);

	CusmeticDto updateCusmetic(CusmeticDto cusmeticDto, UUID cusmeticId);

	void deleteCusmetic(UUID cusmeticId);

	

	

}
