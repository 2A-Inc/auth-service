package com.twoa.tcebi.domain.dto.user;

import com.twoa.tcebi.domain.dto.refresh_token.RefreshTokenDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserAuthResponseDto {
    private Long id;
    private String token;
    private RefreshTokenDto refreshToken;
    private Date issuedAt;
    private Date expiresAt;

}
