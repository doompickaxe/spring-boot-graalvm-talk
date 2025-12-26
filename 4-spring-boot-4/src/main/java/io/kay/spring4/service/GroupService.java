package io.kay.spring4.service;

import io.kay.spring4.domain.Group;
import io.kay.spring4.repository.GroupRepository;
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
