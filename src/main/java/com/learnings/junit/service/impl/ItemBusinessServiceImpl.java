package com.learnings.junit.service.impl;

import com.learnings.junit.model.Item;
import com.learnings.junit.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-17
 */
@Component
public class ItemBusinessServiceImpl {
    @Autowired
    ItemRepository itemRepository;

    public Item getStubItemObject() {
        return new Item(2,"AC",20000,1);
    }

    public List<Item> getAllItemsFromDatabase() {
        List<Item> items = itemRepository.findAll();
        for (Item item:items) item.setValue(item.getPrice() * item.getQuantity());
        return items;
    }
}
