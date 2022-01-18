package com.hinoscape.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hinoscape.app.models.dto.UserDto;
import com.hinoscape.app.models.entity.RoleEntity;
import com.hinoscape.app.models.entity.UserEntity;

@Service
public class UserMapper {
	
	public UserDto toDto(UserEntity userEntity) {
		
		UserDto userDto = new UserDto();
		
		userDto.setUsername(userEntity.getUsername());
		userDto.setPassword(userEntity.getPassword());
		userDto.setEnabled(userEntity.getEnabled());
		userDto.setSurname1(userEntity.getSurname1());
		userDto.setSurname2(userEntity.getSurname2());
		userDto.setName(userEntity.getName());
		userDto.setEmail(userEntity.getEmail());
		
		return userDto;
		
	}
	
public UserEntity toEntity(UserDto userDto) {
		
	UserEntity userEntity = new UserEntity();
	
	userEntity.setName(userDto.getName());
	userEntity.setSurname1(userDto.getSurname1());
	userEntity.setSurname2(userDto.getSurname2());
	userEntity.setName(userDto.getName());
	userEntity.setUsername(userDto.getUsername());
	userEntity.setPassword(userDto.getPassword());
	userEntity.setEnabled(userDto.getEnabled());
	userEntity.setEmail(userDto.getEmail());
	userEntity.setRegisteredAt(userDto.getCreatedAt());
	//userEntity.setBirthDate(userDto.getBirthDate());
	

		
	return userEntity;
		
	}

public List<UserDto> toDtoList(List<UserEntity> usersEntityList){
	
	List<UserDto> userDtoList  = new ArrayList<UserDto>();
	
	for(UserEntity userEntity:usersEntityList) {
		userDtoList.add(toDto(userEntity));
	}
	
	return userDtoList;
}

}
