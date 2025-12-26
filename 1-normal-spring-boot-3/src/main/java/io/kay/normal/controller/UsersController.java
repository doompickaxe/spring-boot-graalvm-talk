package io.kay.normal.controller;

import io.kay.normal.controller.dto.SignUp;
import io.kay.normal.domain.User;
import io.kay.normal.service.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    @ResponseBody
    public User createUser(@RequestBody SignUp signUp) {
        return usersService.createUser(signUp);
    }
}
