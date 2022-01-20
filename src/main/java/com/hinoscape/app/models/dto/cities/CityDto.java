package com.hinoscape.app.models.dto.cities;

import java.util.List;

public class CityDto {
	
	private Long id;
	
	private String name;
	
	private List<RouteDto> routesList;
	
	private String coordinates;
	
	private String errorMsg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RouteDto> getRoutesList() {
		return routesList;
	}

	public void setRoutesList(List<RouteDto> routesList) {
		this.routesList = routesList;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	
}
