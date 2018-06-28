package com.wilkins.resource.server.controllers;

import com.wilkins.resource.server.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor @Slf4j
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public List<User> getUsers() {
        log.info("getUsers");
        return userRepository.findAll();
    }
}
