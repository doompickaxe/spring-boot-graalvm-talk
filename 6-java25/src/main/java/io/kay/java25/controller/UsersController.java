package io.kay.java25.controller;

import io.kay.java25.controller.dto.SignUp;
import io.kay.java25.domain.User;
import io.kay.java25.service.UsersService;
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
