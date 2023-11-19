package com.twoa.tcebi.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String avatarUrl;
    private LocalDateTime birthDay;
    private String description;
    private String userRole;
}
