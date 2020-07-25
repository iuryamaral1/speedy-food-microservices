package com.speedy.food;

import com.speedy.food.dto.InputDto;
import com.speedy.food.dto.OutputDto;
import com.speedy.food.model.Entity;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface Mapper<E extends Entity, IDto extends InputDto, ODto extends OutputDto> {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    E inputDtoToEntity(IDto idto);

    OutputDto entityToOutputDto(E entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(IDto inputDto, @MappingTarget E e);
}
