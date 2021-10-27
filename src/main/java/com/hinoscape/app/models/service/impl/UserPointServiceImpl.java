package com.hinoscape.app.models.service.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hinoscape.app.mapper.UserPointMapper;
import com.hinoscape.app.models.dao.IUserPointDao;
import com.hinoscape.app.models.dto.UserPointDto;
import com.hinoscape.app.models.entity.ChallengeEntity;
import com.hinoscape.app.models.entity.UserEntity;
import com.hinoscape.app.models.entity.UserPointEntity;
import com.hinoscape.app.models.service.IUserPointService;
import com.hinoscape.app.models.service.points.IPointsService;

@Service
public class UserPointServiceImpl implements IUserPointService{
	
	@Autowired
	IPointsService pointsService;
	
	@Autowired
	IUserPointDao userPointDao ;
	
	@Autowired
	UserPointMapper userPointMapper;

	@Override
	public void createPointsNewUser(UserEntity userCreated) {
		List<ChallengeEntity> pointsList = pointsService.findAll();
		
		for(ChallengeEntity point:pointsList) {
			
			UserPointEntity userPointEntity = new UserPointEntity();
			
			userPointEntity.setPointSid(point.getId());
			userPointEntity.setUser(userCreated.getId());
			userPointEntity.setCoordinates(point.getCoordinates());
			userPointEntity.setName(point.getName());
			userPointEntity.setDiscovered(false);
			try {
				userPointDao.save(userPointEntity);
			}catch(PersistenceException pe) {
				
			}
			
		}
		
	}

	@Override
	public List<UserPointDto> getUserPoints(Long userId) throws JSONException {
		// TODO Auto-generated method stub
		return userPointMapper.toDtoList(userPointDao.findUserPointsByUserSid(userId));
	}

}
