package com.hinoscape.app.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.hinoscape.app.models.dto.UserPointDto;
import com.hinoscape.app.models.entity.UserPointEntity;
import com.vividsolutions.jts.geom.Point;

@Service
public class UserPointMapper {
	
	UserPointDto toDto(UserPointEntity userPointEntity) throws JSONException {
		
		UserPointDto userPointDto = new UserPointDto();
		
		userPointDto.setId(userPointEntity.getId());
		userPointDto.setPointSid(userPointEntity.getPointSid());
		userPointDto.setUser(userPointEntity.getUser());
		userPointDto.setName(userPointEntity.getName());
		userPointDto.setCoordinates(convertCoordsToDto(userPointEntity.getCoordinates()) );
		userPointDto.setDiscovered(userPointEntity.getDiscovered());
		return userPointDto;
	};
	
	public List<UserPointDto>toDtoList(List<UserPointEntity> userPointEntityList) throws JSONException{
		
		List<UserPointDto> userPointDtoList = new ArrayList<UserPointDto>();
		
		for(UserPointEntity userPointEntity:userPointEntityList) {
			UserPointDto userPointDto = toDto(userPointEntity);
			userPointDtoList.add(userPointDto);
		}
		return userPointDtoList;
	};
	
	private HashMap<String, String> convertCoordsToDto(Point point) throws JSONException {
		JSONObject geoJson = new JSONObject();
		JSONObject geoJsonGeom = new JSONObject();
		geoJsonGeom.put("coordinates",point.toString());
		geoJson.put("geometry", geoJsonGeom);
		HashMap<String, String> coordsHashMap = new HashMap<>();
		int indexOfFirstParenthesis = point.toString().indexOf('(');
		int indexOfLastParenthesis = point.toString().indexOf(')');
		String coords = point.toString().substring(indexOfFirstParenthesis + 1,
				indexOfLastParenthesis);
		 coordsHashMap.put("coordinates", coords);
		 return coordsHashMap;
	}

}
