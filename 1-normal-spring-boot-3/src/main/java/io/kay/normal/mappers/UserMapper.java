package io.kay.normal.mappers;

import io.kay.normal.controller.dto.UserDto;
import io.kay.normal.domain.User;
import org.mapstruct.Mapper;

@Mapper(config = CentralConfig.class)
public interface UserMapper {

    UserDto toUserDto(User user);
}
