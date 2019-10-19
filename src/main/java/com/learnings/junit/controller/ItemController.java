package com.learnings.junit.controller;

import com.learnings.junit.model.Item;
import com.learnings.junit.service.impl.ItemBusinessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Chetan Raj
 * @implNote
 * @since : 2019-10-16
 */
@RestController
public class ItemController {

    @Autowired
    ItemBusinessServiceImpl businessService;
    @GetMapping("/item")
    public Item item() {
        return new Item(1,"TV",20000,1);
    }

    @GetMapping("/item-business")
    public Item itemFromBusinessService() {
        return businessService.getStubItemObject();
    }

    /* Getting data from databases */
    @GetMapping("/item-list-from-database")
    public List<Item> getAllItemsFromDatabase() {
        return businessService.getAllItemsFromDatabase();
    }
}
