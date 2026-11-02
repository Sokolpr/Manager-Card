package peanutsh.cardservice.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.data.repository.query.Param;
import peanutsh.cardservice.model.dto.request.CreateUserRequest;
import peanutsh.cardservice.model.entity.User;

import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authUserId", source = "userId")
    @Mapping(target = "userStatus", ignore = true)
    @Mapping(target = "userName", source = "request.name")
    @Mapping(target = "userSurname", source = "request.surname")
    @Mapping(target = "createdAt", ignore = true)
    User toEntity(
            @Param("request") CreateUserRequest createUserRequest,
            @Param("userId") UUID userId
    );


}
