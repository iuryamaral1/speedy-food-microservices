package com.speedy.food.dto.item;

import com.speedy.food.dto.OutputDto;
import com.speedy.food.dto.order.OutputOrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutputItemDto extends OutputDto {

    private String itemDescription;
    private String itemPrice;
    private OutputOrderDto itemOrder;
}
