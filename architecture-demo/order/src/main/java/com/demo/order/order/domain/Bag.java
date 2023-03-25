package com.demo.order.order.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Bag {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "bag_id")
    List<BagItem> bagItems;

    @ManyToOne
    private User user;

    // TODO: Move these to a separate interface to better demonstrate the DDD layer
    public void addItem(Item item, int quantity) {
        bagItems.add(new BagItem(item, quantity));
    }

    public void removeItem(Item item) {
        bagItems.removeIf(bagItem -> bagItem.getItem().equals(item));
    }

    public void clearItems() {
        bagItems.clear();
    }

}
