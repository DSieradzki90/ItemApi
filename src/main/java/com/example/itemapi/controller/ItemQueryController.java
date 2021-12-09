package com.example.itemapi.controller;

import com.example.itemapi.entity.Item;
import com.example.itemapi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ItemQueryController {

   private ItemRepository itemRepository;

   @Autowired
    public ItemQueryController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/item")
    public Item getItem(@RequestParam String id) {

        return itemRepository.getById(id);
    }

}
