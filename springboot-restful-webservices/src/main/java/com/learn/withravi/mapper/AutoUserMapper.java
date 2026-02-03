package com.learn.withravi.mapper;

import com.learn.withravi.dto.UserDto;
import com.learn.withravi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper{

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
    UserDto maptoUserDto(User user);
    User maptoUser(UserDto userDto);
}
