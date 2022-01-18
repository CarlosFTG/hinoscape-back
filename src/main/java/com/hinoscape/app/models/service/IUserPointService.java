package com.hinoscape.app.models.service;

import java.util.List;

import org.json.JSONException;

import com.hinoscape.app.models.dto.UserPointDto;
import com.hinoscape.app.models.entity.UserEntity;

public interface IUserPointService {

	List<UserPointDto> getUserPoints(Long userId) throws JSONException;
}
