package com.hinoscape.app.models.service.impl.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hinoscape.app.mapper.city.CityMapper;
import com.hinoscape.app.models.dao.city.ICityDao;
import com.hinoscape.app.models.dto.cities.CityDto;
import com.hinoscape.app.models.entity.city.CityEntity;
import com.hinoscape.app.models.service.city.ICityService;

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
	public CityDto create(CityDto city) {
		//TODO:Llamar a API que obtenga coordenadas
		CityDto cityDto = new CityDto();
		CityEntity createdCityEntity = new CityEntity();
		createdCityEntity=cityDao.save(cityMapper.toEntity(city));
		cityDto=cityMapper.toDto(createdCityEntity);
		return cityDto;
	}

}
