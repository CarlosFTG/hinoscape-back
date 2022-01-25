package com.hinoscape.app.models.service.city;

import com.hinoscape.app.models.dto.cities.RouteDto;
import com.vividsolutions.jts.io.ParseException;

public interface IRouteService {

	RouteDto create(RouteDto route) throws ParseException;

}
