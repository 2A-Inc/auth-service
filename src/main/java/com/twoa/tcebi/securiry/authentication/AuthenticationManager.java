package com.twoa.tcebi.securiry.authentication;

import com.twoa.tcebi.exception.exception.UnauthorizedException;
import com.twoa.tcebi.securiry.CustomPrincipal;
import com.twoa.tcebi.service.user_registration.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuthenticationManager implements ReactiveAuthenticationManager {
    private final UserService userService;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        CustomPrincipal principal = (CustomPrincipal) authentication.getPrincipal();
        return userService.findById(principal.getId())
                .switchIfEmpty(Mono.error(new UnauthorizedException("User disabled")))
                .map(user -> authentication);
    }
}
