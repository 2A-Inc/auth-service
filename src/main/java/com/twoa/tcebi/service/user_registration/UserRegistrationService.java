package com.twoa.tcebi.service.user_registration;

import com.twoa.tcebi.entity.UsersEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRegistrationService {
    Mono<UsersEntity> save(UsersEntity usersEntity);
    Mono<Void> delete();
    Mono<UsersEntity> update();
    Mono<UsersEntity> getById();
    Flux<UsersEntity> getAll();
}
