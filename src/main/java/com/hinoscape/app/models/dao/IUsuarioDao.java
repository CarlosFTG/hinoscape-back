package com.hinoscape.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hinoscape.app.models.entity.UserEntity;

public interface IUsuarioDao extends CrudRepository<UserEntity, Long>{

	public UserEntity findByUsername(String username);
	
	@Query("select c from UserEntity c")
	public List<UserEntity> findAllUsers();
}
