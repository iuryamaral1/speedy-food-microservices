package com.speedy.food.dto.order;

import com.speedy.food.dto.OutputDto;
import com.speedy.food.dto.item.OutputItemDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutputOrderDto extends OutputDto {

    private String descriptionOrder;
    private BigDecimal priceOrder;
    private List<OutputItemDto> itemsOrder;
}
