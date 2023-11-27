package com.twoa.tcebi.domain.entity.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity implements Persistable<Long> {
    @Id
    @Column("id")
    private Long id;
    @Column("first_name")
    private String firstName;
    @Column("middle_name")
    private String middleName;
    @Column("last_name")
    private String lastName;
    @Column("email")
    private String email;
    @Column("password")
    private String password;
    @Column("avatar_url")
    private String avatarUrl;
    @Column("birth_day")
    private LocalDateTime birthDay;
    @Column("description")
    private String description;
    @Column("user_role")
    private String userRole;
    @Column("created_at")
    private LocalDateTime createdAt;
    @Column("updated_at")
    private LocalDateTime updatedAt;
    @Transient
    private boolean isNew;
}
