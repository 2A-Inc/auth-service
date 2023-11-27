package com.twoa.tcebi.mapper.refresh_token;

import com.twoa.tcebi.domain.dto.refresh_token.RefreshTokenDto;
import com.twoa.tcebi.domain.entity.refresh_token.RefreshTokenEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RefreshTokenMapper {
    RefreshTokenDto mapToDto (RefreshTokenEntity refreshTokenEntity);
    RefreshTokenEntity mapToEntity (RefreshTokenDto refreshTokenDto);
}
