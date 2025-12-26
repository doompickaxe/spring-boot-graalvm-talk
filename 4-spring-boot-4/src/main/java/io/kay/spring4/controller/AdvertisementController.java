package io.kay.spring4.controller;

import io.kay.spring4.clients.SmsPushClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {

    private final SmsPushClient pushClient;

    public AdvertisementController(SmsPushClient pushClient) {
        this.pushClient = pushClient;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendSms() {
        pushClient.sendSms("Attend a new Meetup!");
    }
}
