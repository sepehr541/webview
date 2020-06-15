package com.webview.webview.controllers;

import com.webview.webview.model.User;
import com.webview.webview.model.UserWithWebsites;
import com.webview.webview.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class UserController {

    @Autowired
    private UserService userService;


//    @GetMapping("/users/{email}")
//    public User getUser(@PathVariable String email) {
//        return userService.getUserByEmail(email);
//    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/users/{id}")
    public List<UserWithWebsites> getUserWithWebsites(@PathVariable String id) {
        return userService.getUserWithWebsites(id);
    }

}
