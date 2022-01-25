package com.hinoscape.app.models.service.city;

import java.util.List;

import org.json.JSONException;

import com.hinoscape.app.models.dto.cities.CityDto;
import com.vividsolutions.jts.io.ParseException;

public interface ICityService {

	List<CityDto> findAll() throws ParseException;

	CityDto create(CityDto city) throws JSONException, ParseException;

}
