package com.example.itemapi.queries.service;

import com.example.itemapi.commands.repository.ItemRepository;
import com.example.itemapi.common.event.ItemCreatedEvent;
import com.example.itemapi.entity.Item;
import com.example.itemapi.queries.queries.GetItemQuery;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @EventHandler
    public void on(ItemCreatedEvent itemCreatedEvent){
        Item item = itemRepository.findById(itemCreatedEvent.getId()).orElse(null);
    }

    @QueryHandler
    public Item handle(GetItemQuery query){
        Item item = itemRepository
                .findById(query.getId()).orElse(null);

        return item;
    }
}
