package com.hinoscape.app.models.dto;

import java.util.Map;

public class UserPointDto {

	Long id;

	Long user;

	Long pointSid;
	
	Map<String, String> coordinates;
	
	private String name;

	Boolean discovered;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Long getPointSid() {
		return pointSid;
	}

	public void setPointSid(Long pointSid) {
		this.pointSid = pointSid;
	}

	public Boolean getDiscovered() {
		return discovered;
	}

	public void setDiscovered(Boolean discovered) {
		this.discovered = discovered;
	}

	public Map<String, String> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Map<String, String> coordinates) {
		this.coordinates = coordinates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
