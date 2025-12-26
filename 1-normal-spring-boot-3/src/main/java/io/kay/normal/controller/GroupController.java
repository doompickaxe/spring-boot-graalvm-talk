package io.kay.normal.controller;

import io.kay.normal.controller.dto.GroupDto;
import io.kay.normal.mappers.GroupMapper;
import io.kay.normal.service.GroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;
    private final GroupMapper groupMapper;

    public GroupController(GroupService groupService, GroupMapper groupMapper) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
    }

    @GetMapping
    @ResponseBody
    public List<GroupDto> fetchAllGroups() {
        return groupMapper.toGroupsDto(groupService.fetchAllGroups());
    }
}
