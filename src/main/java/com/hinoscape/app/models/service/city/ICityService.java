package com.hinoscape.app.models.service.city;

import java.util.List;

import com.hinoscape.app.models.dto.cities.CityDto;

public interface ICityService {

	List<CityDto> findAll();

	CityDto create(CityDto city);

}
