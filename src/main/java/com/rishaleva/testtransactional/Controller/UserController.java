package com.rishaleva.testtransactional.Controller;

import com.rishaleva.testtransactional.Entity.User;
import com.rishaleva.testtransactional.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<User> getUser() {
        userService.getAllUsers();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/")
    public ResponseEntity<User> saveUser() {
        userService.save();
        return ResponseEntity.ok().build();
    }
}
