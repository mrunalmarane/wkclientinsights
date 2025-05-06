package com.client.insights.mapper;

import com.client.insights.dto.ClientTeamProjectionDto;
import com.client.insights.entity.ClientTeamProjection;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientTeamProjectionDtoMapper {
    ClientTeamProjectionDto toDto(ClientTeamProjection clientTeamProjection);
    ClientTeamProjection toEntity(ClientTeamProjectionDto clientTeamProjectionDto);
    List<ClientTeamProjectionDto> toDtoList(List<ClientTeamProjection> clientTeamProjections);
    List<ClientTeamProjection> toEntityList(List<ClientTeamProjectionDto> clientTeamProjectionDtos);
}
