package com.demo.order.order.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BagItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Item item;

    private int quantity;

    public double calculatePrice() { // TODO: move this to another class (interface) to better illustrate that this
                                     // is just a value object
        return item.getPrice() * quantity;
    }

    public BagItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}
