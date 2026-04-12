package com.ariche.helloworld.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Temporary: allows frontend to talk to it
@RequiredArgsConstructor
public class RootController {

    @GetMapping(
        path = "/hello",
        produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String hello() {
        return "Ping - %s".formatted(Instant.now());
    }

}
