package com.speedy.food.mappers;

import com.speedy.food.dto.OutputDto;
import com.speedy.food.dto.user.InputUserDto;
import com.speedy.food.dto.user.OutputUserDto;
import com.speedy.food.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper extends com.speedy.food.Mapper<User, InputUserDto, OutputUserDto> {

    @Override
    @Mappings( {
            @Mapping(target = "email",    source = "idto.emailUser"),
            @Mapping(target = "password", source = "idto.passUser"),
            @Mapping(target = "login",    source = "idto.loginUser")
    } )
    User inputDtoToEntity(InputUserDto idto);

    @Override
    @Mappings( {
            @Mapping(target = "userLogin",    source = "entity.login"),
            @Mapping(target = "userMail",     source = "entity.email"),
            @Mapping(target = "userPassword", source = "entity.password")
    } )
    OutputDto entityToOutputDto(User entity);

    @Override
    @Mappings( {
            @Mapping(target = "email",    source = "inputDto.emailUser"),
            @Mapping(target = "login",    source = "inputDto.loginUser"),
            @Mapping(target = "password", source = "inputDto.passUser")
    } )
    void updateEntityFromDto(InputUserDto inputDto, @MappingTarget User user);
}
