package io.kay.java25.mappers;

import io.kay.java25.controller.dto.GroupDto;
import io.kay.java25.domain.Group;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = CentralConfig.class, uses = UserMapper.class)
public interface GroupMapper {

    GroupDto toGroupDto(Group group);

    List<GroupDto> toGroupsDto(List<Group> group);
}
