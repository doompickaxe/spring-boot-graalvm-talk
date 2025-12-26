package io.kay.java25.service;

import io.kay.java25.clients.SmsPushClient;
import io.kay.java25.controller.dto.SignUp;
import io.kay.java25.domain.User;
import io.kay.java25.exception.InvalidDataInput;
import io.kay.java25.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final SmsPushClient smsPushClient;

    public UsersService(UsersRepository usersRepository, SmsPushClient smsPushClient) {
        this.usersRepository = usersRepository;
        this.smsPushClient = smsPushClient;
    }

    public User createUser(SignUp signup) {
        if (usersRepository.existsByEmail(signup.email())) {
            throw new InvalidDataInput("Email already in use");
        }

        smsPushClient.sendSms("Verification code: %4d".formatted((int) (Math.random() * 1000)));
        return usersRepository.save(
            new User()
                .setEmail(signup.email())
                .setName(signup.name())
        );
    }
}
