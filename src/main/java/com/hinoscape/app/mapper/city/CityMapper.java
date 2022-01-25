package com.hinoscape.app.mapper.city;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hinoscape.app.models.dto.cities.CityDto;
import com.hinoscape.app.models.entity.city.CityEntity;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

@Service
public class CityMapper {
	
	@Autowired
	RouteMapper routeMapper;
	
	public CityEntity toEntity(CityDto cityDto) throws ParseException {
		
		CityEntity cityEntity = new CityEntity();
		
		cityEntity.setName(cityDto.getName());
		cityEntity.setCoordinates(wktToGeometry(cityDto.getCoordinates()));
		
		return cityEntity;
	}
	
	public CityDto toDto(CityEntity cityEntity) throws ParseException {
		
	CityDto cityDto = new CityDto();
	
	cityDto.setId(cityEntity.getId());
	cityDto.setName(cityEntity.getName());
	cityDto.setCoordinates(cityEntity.getCoordinates().toString());
	cityDto.setRoutesList(routeMapper.toDtoList(cityEntity.getRoutesList()));
		
		return cityDto;
	}
	
	public List<CityDto> toDtoList(List<CityEntity> cityEntityList) throws ParseException{
		List<CityDto> citiesDtoList = new ArrayList<>();
		
		for(CityEntity cityEntity:cityEntityList) {
			citiesDtoList.add(toDto(cityEntity));
		}
		
		return citiesDtoList;
	}
	
	public static Point wktToGeometry(String wellKnownText) throws ParseException {

		Point point = (Point) new WKTReader().read(wellKnownText);
		point.setSRID(3857);
		return point;
	}

}
