package com.twoa.tcebi.repository;

import com.twoa.tcebi.entity.UsersEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends ReactiveCrudRepository<UsersEntity, Long> {
}
