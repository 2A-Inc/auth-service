package com.twoa.tcebi.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationResponseDto {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String avatarUrl;
    private LocalDateTime birthDay;
    private String description;
    private String userRole;
}
