package com.client.insights.mapper;

import com.client.insights.dto.CpmContactDto;
import com.client.insights.entity.CpmContact;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CpmContactDtoMapper {
    CpmContactDto toDto(CpmContact client);
    CpmContact toEntity(CpmContactDto dto);
    List<CpmContactDto> toDtoList(List<CpmContact> clients);
    List<CpmContact> toEntityList(List<CpmContactDto> dtos);
}
