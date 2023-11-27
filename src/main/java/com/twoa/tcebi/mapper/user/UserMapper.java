package com.twoa.tcebi.mapper.user;

import com.twoa.tcebi.domain.dto.user.UserRegistrationRequestDto;
import com.twoa.tcebi.domain.dto.user.UserRegistrationResponseDto;
import com.twoa.tcebi.domain.dto.user.UserResponseDto;
import com.twoa.tcebi.domain.entity.users.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserEntity mapToEntity(UserRegistrationRequestDto userRegistrationRequestDto);

    UserResponseDto mapToDto(UserEntity user);

    UserRegistrationResponseDto mapToResponseDto(UserEntity user);
}
