package com.demo.order.order.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.order.order.domain.Item;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private final ItemRepository itemRepo;

    @Override
    public Item createItem(String name, String description, float price, int quantity) {
        return itemRepo.save(new Item(name, description, price, quantity));
    }

    @Override
    public void updatePrice(Long id, float newPrice) {
        Item item = itemRepo.findById(id).get();
        item.setPrice(newPrice);
        itemRepo.save(item);
    }

    @Override
    public void updateQuantity(Long id, int quantity) {
        Item item = itemRepo.findById(id).get();
        item.setQuantity(quantity);
        itemRepo.save(item);
    }

}
