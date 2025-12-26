package io.kay.normal.service;

import io.kay.normal.clients.SmsPushClient;
import io.kay.normal.controller.dto.SignUp;
import io.kay.normal.domain.User;
import io.kay.normal.exception.InvalidDataInput;
import io.kay.normal.repository.UsersRepository;
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
        // image more business logic here

        return usersRepository.save(
            new User()
                .setEmail(signup.email())
                .setName(signup.name())
        );
    }
}
