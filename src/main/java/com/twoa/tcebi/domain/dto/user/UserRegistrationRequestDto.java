package com.twoa.tcebi.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequestDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private String avatarUrl;
    private LocalDateTime birthDay;
    private String description;
}
