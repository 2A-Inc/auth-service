package com.twoa.tcebi.domain.dto.user;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserAuthResponseDto {
    private Long id;
    private String token;
    private Date issuedAt;
    private Date expiresAt;

}
