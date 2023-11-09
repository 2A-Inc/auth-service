package com.twoa.tcebi.service.user_registration.Impl;

import com.twoa.tcebi.entity.UsersEntity;
import com.twoa.tcebi.repository.UsersRepository;
import com.twoa.tcebi.service.user_registration.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {
    private final UsersRepository usersRepository;
    @Override
    public Mono<UsersEntity> save(UsersEntity usersEntity) {
        return usersRepository.save(usersEntity)
                .onErrorResume(error -> Mono.error(new Exception(error.getMessage())));
    }

    @Override
    public Mono<Void> delete() {
        return null;
    }

    @Override
    public Mono<UsersEntity> update() {
        return null;
    }

    @Override
    public Mono<UsersEntity> getById() {
        return null;
    }

    @Override
    public Flux<UsersEntity> getAll() {
        return null;
    }
}
