package com.springBoot.springMvcRajeeb.web.model;

import org.springframework.beans.factory.annotation.Required;

public class Machine {

	
	private Integer cost;

	public Integer getCost() {
		return cost;
	}

	@Required // Find when it depriciated and why
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
}
