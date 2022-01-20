package com.hinoscape.app.models.service.impl.city;

import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hinoscape.app.mapper.city.CityMapper;
import com.hinoscape.app.models.dao.city.ICityDao;
import com.hinoscape.app.models.dto.cities.CityDto;
import com.hinoscape.app.models.entity.city.CityEntity;
import com.hinoscape.app.models.service.city.ICityService;
import com.hinoscape.app.utils.GeoCoding;
import com.vividsolutions.jts.io.ParseException;

@Service
public class CityServiceImpl implements ICityService{
	
	@Autowired
	ICityDao cityDao;
	
	@Autowired
	CityMapper cityMapper;

	@Override
	public List<CityDto> findAll() {
		List<CityDto> citiesList = cityMapper.toDtoList(cityDao.findAllCities());
		return citiesList;
	}

	@Override
	public CityDto create(CityDto city) throws JSONException, ParseException {
		GeoCoding geoCoding = new GeoCoding();
		HashMap<String, Double> cityCoords = geoCoding.findCityCoordinatesByName(city.getName());
		city.setCoordinates(convertCoordsHasMapToString(cityCoords));
		CityDto cityDto = new CityDto();
		
		CityEntity createdCityEntity = new CityEntity();
		createdCityEntity=cityDao.save(cityMapper.toEntity(city));
		cityDto=cityMapper.toDto(createdCityEntity);
		return cityDto;
	}
	
	private String convertCoordsHasMapToString(HashMap<String, Double> cityCoords) {
		
		String coordsToStr = "POINT("+ cityCoords.get("lon").toString() + " "+cityCoords.get("lat").toString()+")";
		
		return coordsToStr;
	}

}
