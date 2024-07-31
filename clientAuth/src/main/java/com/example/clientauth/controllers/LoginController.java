package com.example.clientauth.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "Please login with: " +
                "<br/><a href='/oauth2/authorization/facebook'>Facebook</a>" +
                "<br/><a href='/oauth2/authorization/google'>Google</a>";
    }
    @GetMapping("/home")
    public Map<String, Object> home(@AuthenticationPrincipal OAuth2User principal) {
        return principal.getAttributes();
    }
}
