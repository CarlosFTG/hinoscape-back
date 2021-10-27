package com.hinoscape.app.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hinoscape.app.models.dto.UserDto;
import com.hinoscape.app.models.entity.UserEntity;

@Service
public class UserMapper {
	
	@Autowired
	RoleMapper roleMapper;
	public UserEntity toEntity(UserDto userDto) {

		UserEntity userEntity = new UserEntity();

		// userEntity.setName(userDto.getName());
		// userEntity.setSurname1(userDto.getSurname1());
		// userEntity.setSurname2(userDto.getSurname2());
		// userEntity.setDni(userDto.getDni());
		userEntity.setUsername(userDto.getUsername());
		userEntity.setPassword(userDto.getPassword());
		userEntity.setEnabled(userDto.getEnabled());
		userEntity.setRoles(roleMapper.toEntityList(userDto.getRoles()));
		// userEntity.setCreatedAt(userDto.getCreatedAt());
		// userEntity.setLastLogin(userDto.getLastLogin());

		return userEntity;
	}

	public UserDto toDto(UserEntity userEntity) {
		UserDto userDto = new UserDto();

		// userDto.setName(userEntity.getName());
		// userDto.setSurname1(userEntity.getSurname1());
		// userDto.setSurname2(userEntity.getSurname2());
		// userDto.setDni(userEntity.getDni());
		userDto.setId(userEntity.getId());
		userDto.setUsername(userEntity.getUsername());
		userDto.setPassword(userEntity.getPassword());
		userDto.setEnabled(userEntity.getEnabled());
		// userDto.setCreatedAt(userEntity.getCreatedAt());
		// userDto.setLastLogin(userEntity.getLastLogin());

		return userDto;
	}
}
