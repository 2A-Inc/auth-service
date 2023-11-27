package com.twoa.tcebi.service.refresh_token.impl;

import com.twoa.tcebi.domain.entity.refresh_token.RefreshTokenEntity;
import com.twoa.tcebi.repository.refresh_token.RefreshTokenRepository;
import com.twoa.tcebi.service.refresh_token.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public Mono<RefreshTokenEntity> save(RefreshTokenEntity refreshToken) {
        return refreshTokenRepository.save(refreshToken);
    }

    @Override
    public Mono<RefreshTokenEntity> findById(String id) {
        return refreshTokenRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return refreshTokenRepository.deleteById(id);
    }
}
