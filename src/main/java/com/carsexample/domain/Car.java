package com.carsexample.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public @NoArgsConstructor @Getter @Setter class Car {
	
	private Long id;
	
	@JsonProperty("id_car")
	private Long idCar;
	
	@JsonProperty("id_user")
	private Long idUser;
	
	@JsonProperty("brand")
	private String brand;
	
	@JsonProperty("model")
	private String model;
	
	@JsonProperty("is_default")
	private Boolean isDefault = true;
	
	@JsonProperty("created_at")
	private Date createdAt;
}
