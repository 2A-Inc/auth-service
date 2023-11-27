package com.twoa.tcebi.service.refresh_token;

import com.twoa.tcebi.domain.entity.refresh_token.RefreshTokenEntity;
import reactor.core.publisher.Mono;

public interface RefreshTokenService {
    Mono<RefreshTokenEntity> save (RefreshTokenEntity refreshToken);
    Mono<RefreshTokenEntity> findById (String id);
    Mono<Void> deleteById (String id);
}
