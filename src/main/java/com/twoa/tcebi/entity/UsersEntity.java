package com.twoa.tcebi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Table(name = "users")
public class UsersEntity {
    @Id
    @Column("id")
    private Long userId;
    @Column("first_name")
    private String firstName;
    @Column("middle_name")
    private String middleName;
    @Column("last_name")
    private String lastName;
    @Column("email")
    private String email;
    @Column("avatar_url")
    private String avatarUrl;
    @Column("birth_dat")
    private LocalDateTime birthDay;
    @Column("description")
    private String description;




}
