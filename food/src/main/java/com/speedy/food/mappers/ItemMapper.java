package com.speedy.food.mappers;

import com.speedy.food.Mapper;
import com.speedy.food.dto.OutputDto;
import com.speedy.food.dto.item.InputItemDto;
import com.speedy.food.dto.item.OutputItemDto;
import com.speedy.food.model.Item;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@org.mapstruct.Mapper(componentModel = "spring")
public interface ItemMapper extends Mapper<Item, InputItemDto, OutputItemDto> {

    @Override
    @Mappings( {
            @Mapping(target = "description",   source = "idto.description"),
            @Mapping(target = "price",         source = "idto.price"),
            @Mapping(target = "order",         source = "idto.inputOrderDto")
    } )
    Item inputDtoToEntity(InputItemDto idto);

    @Override
    @Mappings( {
            @Mapping(target = "itemDescription", source = "entity.description"),
            @Mapping(target = "itemPrice",       source = "entity.price"),
            @Mapping(target = "itemOrder",       source = "entity.order"),
    } )
    OutputDto entityToOutputDto(Item entity);

    @Override
    @Mappings( {
            @Mapping(target = "description",   source = "idto.description"),
            @Mapping(target = "price",         source = "idto.price"),
            @Mapping(target = "order",         source = "idto.inputOrderDto")
    } )
    void updateEntityFromDto(InputItemDto inputDto, Item item);
}
