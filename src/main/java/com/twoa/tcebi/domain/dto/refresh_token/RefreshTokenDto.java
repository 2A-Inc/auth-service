package com.twoa.tcebi.domain.dto.refresh_token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenDto {
    private String id;
    private String refreshToken;
}
