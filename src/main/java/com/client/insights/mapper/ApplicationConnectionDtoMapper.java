package com.client.insights.mapper;

import com.client.insights.dto.ApplicationConnectionDto;
import com.client.insights.entity.ApplicationConnection;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationConnectionDtoMapper {
    ApplicationConnectionDto toDto(ApplicationConnection applicationConnection);
    ApplicationConnection toEntity(ApplicationConnectionDto applicationConnectionDto);
    List<ApplicationConnectionDto> toDtoList(List<ApplicationConnection> applicationConnections);
    List<ApplicationConnection> toEntityList(List<ApplicationConnectionDto> applicationConnectionDtos);
}
