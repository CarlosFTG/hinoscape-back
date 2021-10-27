package com.hinoscape.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.hinoscape.app.models.entity.UserEntity;

public interface IUsuarioDao extends CrudRepository<UserEntity, Long>{

	public UserEntity findByUsername(String username);
}
