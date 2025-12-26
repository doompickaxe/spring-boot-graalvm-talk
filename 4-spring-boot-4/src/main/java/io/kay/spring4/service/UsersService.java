package io.kay.spring4.service;

import io.kay.spring4.clients.SmsPushClient;
import io.kay.spring4.controller.dto.SignUp;
import io.kay.spring4.domain.User;
import io.kay.spring4.exception.InvalidDataInput;
import io.kay.spring4.repository.UsersRepository;
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
