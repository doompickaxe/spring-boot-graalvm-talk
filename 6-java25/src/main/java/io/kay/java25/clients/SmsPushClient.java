package io.kay.java25.clients;

import io.kay.java25.config.SmsPushClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class SmsPushClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsPushClient.class);

    private final RestClient restClient;

    public SmsPushClient(SmsPushClientConfig clientConfig) {
        this.restClient = RestClient.builder()
            .baseUrl(clientConfig.getUrl())
            // This has been done to explicitly check the Content-Length header on the external webserver
            .requestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
            .build();
    }

    @RegisterReflectionForBinding({PushServerRequest.class, PushServerResponse.class})
    public PushServerResponse sendSms(String message) {
        var body = restClient.post()
            .uri("/send-sms")
            .body(new PushServerRequest(message))
            .retrieve()
            .body(PushServerResponse.class);
        LOGGER.info("SMS push response: {}", body);
        return body;
    }
}
