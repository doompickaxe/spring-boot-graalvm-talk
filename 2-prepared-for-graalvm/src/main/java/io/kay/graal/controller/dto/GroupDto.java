package io.kay.graal.controller.dto;

import java.util.List;

public record GroupDto(String name, UserDto owner, List<UserDto> members) {
}
