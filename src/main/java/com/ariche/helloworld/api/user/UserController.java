package com.ariche.helloworld.api.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/me")
@CrossOrigin(origins = "*") // Temporary: allows frontend to talk to it
@RequiredArgsConstructor
public class UserController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> getMessages(@AuthenticationPrincipal final OAuth2User principal) {
        log.info("[GET] Get me");
        return principal.getAttributes();
    }

}
