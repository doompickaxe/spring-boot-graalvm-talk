package io.kay.spring4.mappers;

import io.kay.spring4.controller.dto.GroupDto;
import io.kay.spring4.domain.Group;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = CentralConfig.class, uses = UserMapper.class)
public interface GroupMapper {

    GroupDto toGroupDto(Group group);

    List<GroupDto> toGroupsDto(List<Group> group);
}
