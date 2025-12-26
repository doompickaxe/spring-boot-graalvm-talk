package io.kay.normal.mappers;

import io.kay.normal.controller.dto.GroupDto;
import io.kay.normal.domain.Group;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = CentralConfig.class, uses = UserMapper.class)
public interface GroupMapper {

    GroupDto toGroupDto(Group group);

    List<GroupDto> toGroupsDto(List<Group> group);
}
