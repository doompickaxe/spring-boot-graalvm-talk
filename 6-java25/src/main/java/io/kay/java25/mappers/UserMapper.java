package io.kay.java25.mappers;

import io.kay.java25.controller.dto.UserDto;
import io.kay.java25.domain.User;
import org.mapstruct.Mapper;

@Mapper(config = CentralConfig.class)
public interface UserMapper {

    UserDto toUserDto(User user);
}
