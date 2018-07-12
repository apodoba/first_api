package com.carsexample.controller;

import javax.validation.Valid;

import com.carsexample.domain.ApiAccount;
import com.carsexample.domain.ClientRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carsexample.domain.Car;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CarController {

	@Value("${server.port}")
	private int port;

	@Value("${app.swagger.config}")
	private String swaggerHost;

	@RequestMapping(value = "/cars", method = RequestMethod.POST)
	public ResponseEntity<Car> createCar(@RequestBody @Valid Car car) {
		car.setBrand("New Brand");
		car.setId(1L);

		return new ResponseEntity<>(car, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/cars/delete/{idCar}", method = RequestMethod.POST)
	public ResponseEntity<Object> deleteCarFromService(@PathVariable("idCar") Long idCar, @RequestHeader HttpHeaders headers) {
		return ResponseEntity.noContent().build();
	}
	

	@RequestMapping(value = "/cars/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> listByUserId(@PathVariable("id") Long id){
		Car car = new Car();
		car.setBrand("Brand car");
		car.setId(1L);
		
		return ResponseEntity.ok(car);
	}

	@RequestMapping(value = "/register/{serviceName}", method = RequestMethod.GET)
	public void register(@PathVariable("serviceName") String serviceName) throws UnknownHostException {
		String host = InetAddress.getLoopbackAddress().getHostAddress();
		String address = "http://" + host + ":" + port + "/config/cars.json";

		// Local address
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		Map<String, String> map = new HashMap<>();
		map.put("Content-Type", "application/json");
		headers.setAll(map);

		ApiAccount apiAccount = new ApiAccount();
		apiAccount.setServiceName(serviceName);
		apiAccount.setSpecUrl(address);
		ClientRequest clientRequest = new ClientRequest();
		clientRequest.setData(apiAccount);
		HttpEntity<ClientRequest> request = new HttpEntity<>(clientRequest, headers);
		String url = "http://" + swaggerHost + "/apiSwagger/register";
		ResponseEntity<?> response = new RestTemplate().postForEntity(url, request, String.class);
	}
}