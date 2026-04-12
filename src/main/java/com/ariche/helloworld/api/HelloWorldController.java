package com.ariche.helloworld.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Temporary: allows frontend to talk to it
public class HelloWorldController {

    @GetMapping(
            path = "/hello",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String hello() {
        return "Hello World";
    }
}
