package com.speedy.food.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
@javax.persistence.Entity
@Table(name = "order")
public class Order extends Entity {

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 100)
    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @NotNull
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "order", orphanRemoval = true)
    private List<Item> items;

    public Order(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
        this.items = new ArrayList<>();
    }

    public BigDecimal getTotalPrice() {
        return this.items.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
