package com.hinoscape.app.models.service.points;

import java.util.List;

import com.hinoscape.app.models.entity.ChallengeEntity;

public interface IPointsService {
	List<ChallengeEntity> findAll();
}
