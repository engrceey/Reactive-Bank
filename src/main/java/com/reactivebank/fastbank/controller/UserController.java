package com.reactivebank.fastbank.controller;

import com.reactivebank.fastbank.entities.AppUser;
import com.reactivebank.fastbank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping
    public Flux<AppUser> getAllUsers() {
        return userService.fetchAllUsers();
    }

    @GetMapping(path = "{userId}")
    public Mono<ResponseEntity<AppUser>> getAppUserById(@PathVariable Long userId) {
        return userService.getAppUserById(userId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<AppUser> registerAppUser(@RequestBody AppUser appUser) {
        return userService.registerNewUser(appUser);
    }

    @PutMapping(path = "/{userId}")
    public Mono<AppUser> updateAppUser(@PathVariable Long userId, AppUser appUser) {
        return userService.updateAppUser(userId, appUser);
    }

    @DeleteMapping(path = "/{userId}")
    public Mono<Void> deleteAppUser(@PathVariable Long userId) {
       return userService.deleteAppUser(userId);
    }
}
