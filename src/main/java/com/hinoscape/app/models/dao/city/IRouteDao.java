package com.hinoscape.app.models.dao.city;

import org.springframework.data.repository.CrudRepository;
import com.hinoscape.app.models.entity.city.RouteEntity;

public interface IRouteDao extends CrudRepository<RouteEntity, Long>{

}
