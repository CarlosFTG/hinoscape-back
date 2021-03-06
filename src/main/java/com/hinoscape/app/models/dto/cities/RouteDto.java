package com.hinoscape.app.models.dto.cities;

import java.util.List;

import com.hinoscape.app.models.entity.city.RoutesPointsEntity;

public class RouteDto {
private Long id;
	
	private String name;
	
	private String observations;
	
	private String coordinates;
	
	Long city;
	
	List<RoutesPointsDto> routePoints;

	
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

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public Long getCity() {
		return city;
	}

	public void setCity(Long city) {
		this.city = city;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public List<RoutesPointsDto> getRoutePoints() {
		return routePoints;
	}

	public void setRoutePoints(List<RoutesPointsDto> routePoints) {
		this.routePoints = routePoints;
	}
	
	
}
