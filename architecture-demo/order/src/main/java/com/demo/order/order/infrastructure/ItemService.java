package com.demo.order.order.infrastructure;

import com.demo.order.order.domain.Item;

public interface ItemService {
    Item createItem(String name, String description, float price, int quantity);

    void updatePrice(Long id, float newPrice);

    void updateQuantity(Long id, int quantity);
}
