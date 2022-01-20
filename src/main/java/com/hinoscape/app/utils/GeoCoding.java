package com.hinoscape.app.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GeoCoding {
	
	@Value("${open.weatherapp.key}")
	private String openWeatherappKey;

	public HashMap<String, Double> findCityCoordinatesByName(String cityName) throws JSONException {
		String cityCoords = "";

		RestTemplate restTemplate = new RestTemplate();

		final String url = "http://api.openweathermap.org/geo/1.0/direct?q=" + cityName + "&limit=" + 1 + "&appid="
				+ openWeatherappKey;
		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(url, Object[].class);

		Object[] objects = responseEntity.getBody();

		List<Double> lat = getLat(objects);
		List<Double> lon = getLong(objects);
		
		HashMap<String, Double> coordsHashMap = new HashMap<>();
		
		coordsHashMap.put("lat", lat.get(0));
		coordsHashMap.put("lon", lon.get(0));

		return coordsHashMap;
	}

	private List<Double> getLat(Object[] objects) {

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		return Arrays.stream(objects).map(object -> mapper.convertValue(object, GeoCodingResponse.class))
				.map(GeoCodingResponse::getLat).collect(Collectors.toList());
	}

	private List<Double> getLong(Object[] objects) {

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		return Arrays.stream(objects).map(object -> mapper.convertValue(object, GeoCodingResponse.class))
				.map(GeoCodingResponse::getLon).collect(Collectors.toList());
	}
}
