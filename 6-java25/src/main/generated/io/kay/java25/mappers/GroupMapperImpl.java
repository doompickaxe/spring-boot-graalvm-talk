package io.kay.java25.mappers;

import io.kay.java25.controller.dto.GroupDto;
import io.kay.java25.controller.dto.UserDto;
import io.kay.java25.domain.Group;
import io.kay.java25.domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-12T22:02:39+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class GroupMapperImpl implements GroupMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public GroupDto toGroupDto(Group group) {
        if ( group == null ) {
            return null;
        }

        String name = null;
        UserDto owner = null;
        List<UserDto> members = null;

        name = group.getName();
        owner = userMapper.toUserDto( group.getOwner() );
        members = userListToUserDtoList( group.getMembers() );

        GroupDto groupDto = new GroupDto( name, owner, members );

        return groupDto;
    }

    @Override
    public List<GroupDto> toGroupsDto(List<Group> group) {
        if ( group == null ) {
            return null;
        }

        List<GroupDto> list = new ArrayList<GroupDto>( group.size() );
        for ( Group group1 : group ) {
            list.add( toGroupDto( group1 ) );
        }

        return list;
    }

    protected List<UserDto> userListToUserDtoList(List<User> list) {
        if ( list == null ) {
            return null;
        }

        List<UserDto> list1 = new ArrayList<UserDto>( list.size() );
        for ( User user : list ) {
            list1.add( userMapper.toUserDto( user ) );
        }

        return list1;
    }
}
