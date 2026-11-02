package peanutsh.cardservice.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.data.repository.query.Param;
import peanutsh.cardservice.model.dto.request.CreateCardRequest;
import peanutsh.cardservice.model.entity.Card;
import peanutsh.cardservice.model.entity.User;

import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CardMapper {


    @Mapping(target = "id",ignore = true)
    @Mapping(target = "pan", ignore = true)
    @Mapping(target = "pin",source = "pin")
    @Mapping(target = "")
    Card toEntity(
           @Param("user") User user,
           @Param("pin") CreateCardRequest createCardRequest
    );

}
