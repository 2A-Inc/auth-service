package com.twoa.tcebi.rest.auth;

import com.twoa.tcebi.domain.dto.user.*;
import com.twoa.tcebi.mapper.refresh_token.RefreshTokenMapper;
import com.twoa.tcebi.mapper.user.UserMapper;
import com.twoa.tcebi.securiry.CustomPrincipal;
import com.twoa.tcebi.securiry.SecurityService;
import com.twoa.tcebi.service.user_registration.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthRestControllerV1 {
    private final SecurityService securityService;
    private final UserService userService;
    private final UserMapper userMapper;
    private final RefreshTokenMapper refreshTokenMapper;


    @PostMapping("/register")
    public Mono<UserRegistrationResponseDto> register(@RequestBody UserRegistrationRequestDto dto) {
        return userService.registerUser(dto)
                .map(userMapper::mapToResponseDto);
    }

    @PostMapping("/login")
    public Mono<UserAuthResponseDto> login(@RequestBody UserAuthRequestDto dto) {
        return securityService.authenticate(dto.getEmail(), dto.getPassword())
                .flatMap(tokenDetails -> Mono.just(
                        UserAuthResponseDto.builder()
                                .id(tokenDetails.getUserId())
                                .token(tokenDetails.getToken())
                                .refreshToken(refreshTokenMapper.mapToDto(tokenDetails.getRefreshToken()))
                                .issuedAt(tokenDetails.getIssuedAt())
                                .expiresAt(tokenDetails.getExpiresAt())
                                .build()
                ));
    }

    @GetMapping("/info")
    public Mono<UserResponseDto> getUserInfo(Authentication authentication) {
        CustomPrincipal customPrincipal = (CustomPrincipal) authentication.getPrincipal();

        return userService.findById(customPrincipal.getId())
                .map(userMapper::mapToDto);
    }
}
