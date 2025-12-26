package io.kay.cloudgateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SampleController {

    @RequestMapping("/api/sample")
    @ResponseBody
    public Mono<SampleResponse> sample() {
        return Mono.just(new SampleResponse("Success!"));
    }
}
