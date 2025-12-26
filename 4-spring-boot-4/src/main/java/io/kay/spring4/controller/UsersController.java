package io.kay.spring4.controller;

import io.kay.spring4.controller.dto.SignUp;
import io.kay.spring4.domain.User;
import io.kay.spring4.service.UsersService;
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
