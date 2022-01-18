package com.hinoscape.app.models.dao.city;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hinoscape.app.models.entity.UserEntity;
import com.hinoscape.app.models.entity.city.CityEntity;

public interface ICityDao extends CrudRepository<CityEntity, Long> {
	@Query("select c from CityEntity c")
	public List<CityEntity> findAllCities();
}
