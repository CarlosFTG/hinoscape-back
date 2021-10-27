package com.hinoscape.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Point;

@Entity
@Table(name = "users_points")
public class UserPointEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "user_sid")
	Long user;
	
	@Column(name = "point_sid")
	Long pointSid;
	
	@Column(name = "coordinates")
	private Point coordinates;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "discovered")
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

	public Point getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Point coordinates) {
		this.coordinates = coordinates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
