package io.kay.normal.service;

import io.kay.normal.domain.Group;
import io.kay.normal.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> fetchAllGroups() {
        return groupRepository.findAll();
    }
}
