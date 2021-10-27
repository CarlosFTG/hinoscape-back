package com.hinoscape.app.models.service.points.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hinoscape.app.models.dao.IPointsDao;
import com.hinoscape.app.models.entity.ChallengeEntity;
import com.hinoscape.app.models.service.points.IPointsService;

@Service
public class PointsServiceImpl implements IPointsService{
	
	@Autowired
	IPointsDao pointsDao;

	@Override
	public List<ChallengeEntity> findAll() {
		return pointsDao.findAll();
	}

}
