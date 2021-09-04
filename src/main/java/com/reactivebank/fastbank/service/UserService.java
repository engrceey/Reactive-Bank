package com.reactivebank.fastbank.service;

import com.reactivebank.fastbank.entities.AppUser;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface UserService {

    Mono<AppUser> getAppUserById(Long id);

    Flux<AppUser> fetchAllUsers();

    Mono<AppUser> registerNewUser(AppUser user);

    Mono<AppUser> updateAppUser(Long userId, AppUser appUser);

    Mono<Void> deleteAppUser(Long userId);

}
