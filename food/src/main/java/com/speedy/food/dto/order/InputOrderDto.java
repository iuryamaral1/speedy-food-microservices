package com.speedy.food.dto.order;

import com.speedy.food.dto.InputDto;
import com.speedy.food.dto.item.InputItemDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputOrderDto extends InputDto {

    private String orderDescription;
    private BigDecimal orderPrice;
    private List<InputItemDto> orderItems;
}
