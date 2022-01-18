package com.hinoscape.app.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hinoscape.app.models.dto.cities.CityDto;
import com.hinoscape.app.models.service.city.ICityService;

@Controller
@RequestMapping("/api/cities")
public class CitiesController {
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	ICityService cityService;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping(value = {"/findAll"}, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.FOUND)
	public ResponseEntity<List<CityDto>> findAll()   {

		return ResponseEntity.ok(this.cityService.findAll());
	}
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value = {"/create"}, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.FOUND)
	public ResponseEntity<CityDto> create(@RequestBody CityDto city)   {
		CityDto createdCity = new CityDto();
		try {
			createdCity= this.cityService.create(city);
			
		}catch(Exception e) {
			logger.error(e);
			createdCity.setErrorMsg(e.getMessage());
		}
		return ResponseEntity.ok(createdCity);
	}
}
