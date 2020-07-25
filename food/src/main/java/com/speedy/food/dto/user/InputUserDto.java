package com.speedy.food.dto.user;

import com.speedy.food.dto.InputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputUserDto extends InputDto {

    private String emailUser;
    private String loginUser;
    private String passUser;
}
