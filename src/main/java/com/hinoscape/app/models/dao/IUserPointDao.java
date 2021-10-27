package com.hinoscape.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hinoscape.app.models.entity.UserPointEntity;

public interface IUserPointDao  extends JpaRepository<UserPointEntity, Long>{

	@Query("SELECT up FROM UserPointEntity up WHERE up.user = :userSid")
	List<UserPointEntity> findUserPointsByUserSid(@Param("userSid")Long userSid);
}
