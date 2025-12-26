package io.kay.normal.mappers;

import io.kay.normal.controller.dto.UserDto;
import io.kay.normal.domain.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-14T11:01:15+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Eclipse Adoptium)"
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
