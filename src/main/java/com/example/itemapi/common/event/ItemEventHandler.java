package com.example.itemapi.common.event;

import com.example.itemapi.entity.Item;
import com.example.itemapi.commands.repository.ItemRepository;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemEventHandler {

    private ItemRepository itemRepository;

    @Autowired
    public ItemEventHandler(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @EventSourcingHandler
    public void on(ItemCreated itemCreated){

        Item item = new Item();
        BeanUtils.copyProperties(itemCreated,item);
        itemRepository.save(item);

    }
}
