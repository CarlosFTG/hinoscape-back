package com.hinoscape.app.mapper.city;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hinoscape.app.models.dto.cities.CityDto;
import com.hinoscape.app.models.entity.city.CityEntity;

@Service
public class CityMapper {
	
	public CityEntity toEntity(CityDto cityDto) {
		
		CityEntity cityEntity = new CityEntity();
		
		cityEntity.setName(cityDto.getName());
		
		return cityEntity;
	}
	
	public CityDto toDto(CityEntity cityEntity) {
		
	CityDto cityDto = new CityDto();
		
	cityDto.setName(cityEntity.getName());
		
		return cityDto;
	}
	
	public List<CityDto> toDtoList(List<CityEntity> cityEntityList){
		List<CityDto> citiesDtoList = new ArrayList<>();
		
		for(CityEntity cityEntity:cityEntityList) {
			citiesDtoList.add(toDto(cityEntity));
		}
		
		return citiesDtoList;
	}

}
