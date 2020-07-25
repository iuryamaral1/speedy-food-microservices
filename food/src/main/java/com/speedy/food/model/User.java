package com.speedy.food.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@javax.persistence.Entity
@Table(name = "user")
public class User extends Entity {

    @Email
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 4, max = 30)
    @Column(name = "email", nullable = false, unique = true, length = 30)
    private String email;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 6, max = 30)
    @Column(name = "password", length = 30, nullable = false)
    private String password;

    @NotBlank
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 30)
    @Column(name = "login", length = 30, nullable = false, unique = true)
    private String login;

}
