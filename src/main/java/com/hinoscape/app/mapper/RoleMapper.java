package com.hinoscape.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hinoscape.app.models.dto.RoleDto;
import com.hinoscape.app.models.entity.RoleEntity;

@Service
public class RoleMapper {
	
	public RoleEntity toEntity(RoleDto roleDto) {
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setAuthority(roleDto.getAuthority());
		roleEntity.setUserId(roleDto.getUserId());
		roleEntity.setAuthorityId(roleDto.getAuthorityId());
		return roleEntity;
	}
	
	public List<RoleEntity> toEntityList(List<RoleDto> roleDtoList) {
		
		List<RoleEntity> roleEntityList = new ArrayList<RoleEntity>();
		
		for(RoleDto roleDto:roleDtoList) {
			
			RoleEntity roleEntity =toEntity(roleDto);
			roleEntityList.add(roleEntity);
		}
				
		return roleEntityList;
	}

}
