package io.kay.spring4.mappers;

import io.kay.spring4.controller.dto.UserDto;
import io.kay.spring4.domain.User;
import org.mapstruct.Mapper;

@Mapper(config = CentralConfig.class)
public interface UserMapper {

    UserDto toUserDto(User user);
}
