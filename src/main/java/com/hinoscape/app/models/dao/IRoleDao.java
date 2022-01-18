package com.hinoscape.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.hinoscape.app.models.entity.RoleEntity;

public interface IRoleDao extends CrudRepository<RoleEntity, Long>{

}
