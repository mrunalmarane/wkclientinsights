package com.client.insights.mapper;

import com.client.insights.dto.ContactProjectionDto;
import com.client.insights.entity.ContactProjection;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactProjectionDtoMapper {
    ContactProjectionDto toDto(ContactProjection contactProjection);
    ContactProjection toEntity(ContactProjectionDto contactProjectionDto);
    List<ContactProjectionDto> toDtoList(List<ContactProjection> contactProjections);
    List<ContactProjection> toEntityList(List<ContactProjectionDto> contactProjectionDtos);
}

