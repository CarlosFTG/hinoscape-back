package com.hinoscape.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hinoscape.app.models.entity.ChallengeEntity;

public interface IPointsDao extends JpaRepository<ChallengeEntity, Long> {

}
