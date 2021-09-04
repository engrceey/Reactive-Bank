package com.reactivebank.fastbank.repositories;

import com.reactivebank.fastbank.entities.AppUser;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveCrudRepository<AppUser, Long> {
}
