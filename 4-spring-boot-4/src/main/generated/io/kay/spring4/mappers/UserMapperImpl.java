package io.kay.spring4.mappers;

import io.kay.spring4.controller.dto.UserDto;
import io.kay.spring4.domain.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-03T12:31:36+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        String name = null;
        String email = null;

        name = user.getName();
        email = user.getEmail();

        UserDto userDto = new UserDto( name, email );

        return userDto;
    }
}
