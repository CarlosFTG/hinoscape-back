package com.hinoscape.app.mapper.city;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hinoscape.app.models.dto.cities.RouteDto;
import com.hinoscape.app.models.entity.city.RouteEntity;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

@Service
public class RouteMapper {
	
	@Autowired
	RoutesPointsMapper rpMapper;
	
	public RouteEntity toEntity(RouteDto routeDto) throws ParseException {
		
		RouteEntity routeEntity = new RouteEntity();
		
		routeEntity.setName(routeDto.getName());
		routeEntity.setObservations(routeDto.getObservations());
		routeEntity.setCity(routeDto.getCity());
		routeEntity.setRoutePoints(rpMapper.toEntityList(routeDto.getRoutePoints()));
		return routeEntity;
	}
	
	public RouteDto toDto(RouteEntity routeEntity) throws ParseException {
		RouteDto routeDto = new RouteDto();
		
		routeDto.setName(routeEntity.getName());
		routeDto.setObservations(routeEntity.getObservations());
		routeDto.setCity(routeEntity.getCity());
		routeDto.setRoutePoints(rpMapper.toDtoList(routeEntity.getRoutePoints()));
		
		return routeDto;
	}
	
	public List<RouteDto> toDtoList(List<RouteEntity> routeEntityList) throws ParseException {
		
		List<RouteDto> routeDtoList = new ArrayList<RouteDto>();
		
		for(RouteEntity routeEntity:routeEntityList) {
			routeDtoList.add(toDto(routeEntity));
		}
		
		return routeDtoList;
		
	}
	
	public static LineString wktToGeometry(String wellKnownText) throws ParseException {

		LineString line = (LineString) new WKTReader().read(wellKnownText);
		line.setSRID(3857);
		return line;
	}

}
