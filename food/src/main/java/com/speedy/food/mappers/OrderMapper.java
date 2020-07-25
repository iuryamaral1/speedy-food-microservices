package com.speedy.food.mappers;

import com.speedy.food.dto.OutputDto;
import com.speedy.food.dto.order.InputOrderDto;
import com.speedy.food.dto.order.OutputOrderDto;
import com.speedy.food.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OrderMapper extends com.speedy.food.Mapper<Order, InputOrderDto, OutputOrderDto> {

    @Override
    @Mappings( {
            @Mapping(target = "description",   source = "idto.orderDescription"),
            @Mapping(target = "price",         source = "idto.orderPrice"),
            @Mapping(target = "items",         source = "idto.orderItems")
    } )
    Order inputDtoToEntity(InputOrderDto idto);

    @Override
    @Mappings( {
            @Mapping(target = "descriptionOrder",  source = "entity.description"),
            @Mapping(target = "priceOrder",             source = "entity.price"),
            @Mapping(target = "itemsOrder",             source = "entity.items")
    } )
    OutputDto entityToOutputDto(Order entity);

    @Override
    @Mappings( {
            @Mapping(target = "description",   source = "idto.orderDescription"),
            @Mapping(target = "price",         source = "idto.orderPrice"),
            @Mapping(target = "items",         source = "idto.orderItems")
    } )
    void updateEntityFromDto(InputOrderDto inputDto, Order order);
}
