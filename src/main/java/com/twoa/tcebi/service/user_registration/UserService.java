package com.twoa.tcebi.service.user_registration;

import com.twoa.tcebi.domain.dto.user.UserRegistrationRequestDto;
import com.twoa.tcebi.domain.dto.user.UserUpdateRequestDto;
import com.twoa.tcebi.domain.entity.users.UserEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<Void> deleteById(Long id);
    Mono<UserEntity> update(UserUpdateRequestDto userUpdateRequestDto);
    Mono<UserEntity> findById(Long id);
    Flux<UserEntity> getAll();
    Mono<UserEntity> findByEmail(String email);
    Mono<UserEntity> registerUser(UserRegistrationRequestDto userUpdateRequestDto);
}
