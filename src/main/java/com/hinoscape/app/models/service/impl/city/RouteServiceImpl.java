package com.hinoscape.app.models.service.impl.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hinoscape.app.mapper.city.RouteMapper;
import com.hinoscape.app.models.dao.city.IRouteDao;
import com.hinoscape.app.models.dto.cities.RouteDto;
import com.hinoscape.app.models.entity.city.RouteEntity;
import com.hinoscape.app.models.service.city.IRouteService;
import com.vividsolutions.jts.io.ParseException;

@Service
public class RouteServiceImpl implements IRouteService{
	
	@Autowired
	IRouteDao routeDao;
	
	@Autowired
	RouteMapper routeMapper;

	@Override
	public RouteDto create(RouteDto routeDto) throws ParseException {
		
		RouteEntity createdRouteEntity = new RouteEntity();
		RouteDto createdRouteDto = new RouteDto();
		createdRouteEntity=routeDao.save(routeMapper.toEntity(routeDto));
		createdRouteDto= routeMapper.toDto(createdRouteEntity);
		return createdRouteDto;
	}

}
