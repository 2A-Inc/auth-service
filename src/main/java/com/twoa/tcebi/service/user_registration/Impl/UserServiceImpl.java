package com.twoa.tcebi.service.user_registration.Impl;

import com.twoa.tcebi.domain.dto.user.UserRegistrationRequestDto;
import com.twoa.tcebi.domain.dto.user.UserUpdateRequestDto;
import com.twoa.tcebi.domain.entity.UserEntity;
import com.twoa.tcebi.domain.enums.UserRole;
import com.twoa.tcebi.mapper.user.UserMapper;
import com.twoa.tcebi.repository.user_repository.UsersRepository;
import com.twoa.tcebi.securiry.password_encoder.PBKDF2PasswordEncoder;
import com.twoa.tcebi.service.user_registration.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    private final PBKDF2PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public Mono<UserEntity> registerUser(UserRegistrationRequestDto userUpdateRequestDto) {
        final UserEntity userEntity = userMapper.mapToEntity(userUpdateRequestDto);
        System.out.println(userEntity);
        return usersRepository.save(
                userEntity.toBuilder()
                        .firstName(userEntity.getFirstName())
                        .middleName(userEntity.getMiddleName())
                        .lastName(userEntity.getLastName())
                        .email(userEntity.getEmail())
                        .password(passwordEncoder.encode(userEntity.getPassword()))
                        .avatarUrl(userEntity.getAvatarUrl())
                        .birthDay(userEntity.getBirthDay())
                        .description(userEntity.getDescription())
                        .userRole(UserRole.USER.name())
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .isNew(true)
                        .build()
        ).doOnSuccess(u -> {
            log.info("IN registerUser - user: {} created", u);
        });
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return usersRepository.deleteById(id);
    }

    @Override
    public Mono<UserEntity> update(UserUpdateRequestDto userUpdateRequestDto) {
        final UserEntity userEntity = updateUserEntityBuildMethod(userUpdateRequestDto);
        return usersRepository.save(userEntity);
    }

    @Override
    public Mono<UserEntity> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Flux<UserEntity> getAll() {
        return null;
    }

    @Override
    public Mono<UserEntity> findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    private UserEntity updateUserEntityBuildMethod(UserUpdateRequestDto userUpdateRequestDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userUpdateRequestDto.getFirstName());
        userEntity.setMiddleName(userUpdateRequestDto.getMiddleName());
        userEntity.setLastName(userUpdateRequestDto.getLastName());
        userEntity.setEmail(userUpdateRequestDto.getEmail());
        userEntity.setAvatarUrl(userUpdateRequestDto.getAvatarUrl());
        userEntity.setDescription(userUpdateRequestDto.getDescription());
        userEntity.setNew(false);
        return userEntity;
    }
}
