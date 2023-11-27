package com.twoa.tcebi.repository.refresh_token;

import com.twoa.tcebi.domain.entity.refresh_token.RefreshTokenEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends ReactiveCrudRepository<RefreshTokenEntity, String> {
}
