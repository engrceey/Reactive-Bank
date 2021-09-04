package com.reactivebank.fastbank.service.implementation;

import com.reactivebank.fastbank.entities.AppUser;
import com.reactivebank.fastbank.repositories.UserRepository;
import com.reactivebank.fastbank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public Mono<AppUser> getAppUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Flux<AppUser> fetchAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<AppUser> registerNewUser(AppUser user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<AppUser> updateAppUser(Long userId, AppUser appUser) {
        return userRepository.findById(userId)
                .map((e) -> {
                    e.setFirstName(appUser.getFirstName());
                    e.setLastName(appUser.getLastName());
                    e.setEmail(appUser.getEmail());
                    e.setPhoneNumber(appUser.getPhoneNumber());
                    e.setRole(appUser.getRole());
                    return e;
                }).flatMap(userRepository::save);
    }

    @Override
    public Mono<Void> deleteAppUser(Long userId) {
       return   userRepository.deleteById(userId);
    }


}
