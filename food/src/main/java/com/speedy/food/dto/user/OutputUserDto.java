package com.speedy.food.dto.user;

import com.speedy.food.dto.OutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutputUserDto extends OutputDto {

    private String userLogin;
    private String userMail;
    private String userPassword;
}
