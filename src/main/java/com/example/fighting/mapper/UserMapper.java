package com.example.fighting.mapper;

import com.example.fighting.dto.UserDto;
import com.example.fighting.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserDto entityToDto(User user);

  @Mapping(target = "id", ignore = true)
  User dtoToEntity(UserDto userDto);
}
