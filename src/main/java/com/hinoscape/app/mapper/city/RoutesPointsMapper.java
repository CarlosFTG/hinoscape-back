package com.hinoscape.app.mapper.city;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hinoscape.app.models.dto.cities.RoutesPointsDto;
import com.hinoscape.app.models.entity.city.RoutesPointsEntity;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

@Service
public class RoutesPointsMapper {

	public RoutesPointsEntity toEntity(RoutesPointsDto routesPointsDto) throws ParseException {
		RoutesPointsEntity routesPointsEntity = new RoutesPointsEntity();

		routesPointsEntity.setName(routesPointsDto.getName());
		routesPointsEntity.setObservations(routesPointsDto.getObservations());
		routesPointsEntity.setCoordinates(wktToGeometry(routesPointsDto.getCoordinates()));
		//routesPointsEntity.setRoute(routesPointsDto.getRoute());

		return routesPointsEntity;
	}

	public RoutesPointsDto toDto(RoutesPointsEntity routesPointsEntity) throws ParseException {
		RoutesPointsDto routesPointsDto = new RoutesPointsDto();

		routesPointsDto.setName(routesPointsEntity.getName());
		routesPointsDto.setObservations(routesPointsEntity.getObservations());
		routesPointsDto.setCoordinates(routesPointsEntity.getCoordinates().toString());
		routesPointsDto.setRoute(routesPointsEntity.getRoute());

		return routesPointsDto;
	}

	public List<RoutesPointsEntity> toEntityList(List<RoutesPointsDto> routePointDtoList) throws ParseException {

		List<RoutesPointsEntity> routePointsEntityList = new ArrayList<RoutesPointsEntity>();

		for (RoutesPointsDto routeDto : routePointDtoList) {
			routePointsEntityList.add(toEntity(routeDto));
		}

		return routePointsEntityList;
	}
	
	public List<RoutesPointsDto> toDtoList(List<RoutesPointsEntity> routePointEntityList) throws ParseException {

		List<RoutesPointsDto> routeDtoList = new ArrayList<RoutesPointsDto>();

		for (RoutesPointsEntity routeEntity : routePointEntityList) {
			routeDtoList.add(toDto(routeEntity));
		}

		return routeDtoList;
	}

	public static Point wktToGeometry(String wellKnownText) throws ParseException {

		Point point = (Point) new WKTReader().read(wellKnownText);
		point.setSRID(3857);
		return point;
	}
}
