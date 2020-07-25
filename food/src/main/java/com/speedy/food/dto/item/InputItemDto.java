package com.speedy.food.dto.item;

import com.speedy.food.dto.InputDto;
import com.speedy.food.dto.order.InputOrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputItemDto extends InputDto {

    private String description;
    private BigDecimal price;
    private InputOrderDto inputOrderDto;
}
