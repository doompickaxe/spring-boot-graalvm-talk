package io.kay.graal.controller;

import io.kay.graal.controller.dto.SignUp;
import io.kay.graal.domain.User;
import io.kay.graal.service.UsersService;
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
