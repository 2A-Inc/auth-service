package com.twoa.tcebi.domain.dto.user;

import lombok.Data;

@Data
public class UserAuthRequestDto {
    private String email;
    private String password;
}
