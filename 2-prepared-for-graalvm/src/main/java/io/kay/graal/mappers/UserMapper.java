package io.kay.graal.mappers;

import io.kay.graal.controller.dto.UserDto;
import io.kay.graal.domain.User;
import org.mapstruct.Mapper;

@Mapper(config = CentralConfig.class)
public interface UserMapper {

    UserDto toUserDto(User user);
}
