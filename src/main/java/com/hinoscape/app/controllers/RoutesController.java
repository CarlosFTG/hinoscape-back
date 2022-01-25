package com.hinoscape.app.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hinoscape.app.models.dto.cities.CityDto;
import com.hinoscape.app.models.dto.cities.RouteDto;
import com.hinoscape.app.models.service.city.ICityService;
import com.hinoscape.app.models.service.city.IRouteService;

@Controller
@RequestMapping("/api/routes")
public class RoutesController {
	
	protected final Log logger = LogFactory.getLog(this.getClass());

	
	@Autowired
	IRouteService routeService;
	
	@RequestMapping(value = {"/create"}, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.FOUND)
	public ResponseEntity<RouteDto> create(@RequestBody RouteDto route)   {
		RouteDto createdRoute = new RouteDto();
		try {
			createdRoute= this.routeService.create(route);
			
		}catch(Exception e) {
			logger.error(e);
			createdRoute.setErrorMsg(e.getMessage());
		}
		return ResponseEntity.ok(createdRoute);
	}

}
