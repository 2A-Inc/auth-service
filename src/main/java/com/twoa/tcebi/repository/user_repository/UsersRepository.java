package com.twoa.tcebi.repository.user_repository;

import com.twoa.tcebi.domain.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UsersRepository extends ReactiveCrudRepository<UserEntity, Long> {
    Mono<UserEntity> findByEmail(String email);
}
