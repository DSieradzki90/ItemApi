package com.example.itemapi.commands.controller;

import com.example.itemapi.commands.command.CreateItemCommand;
import com.example.itemapi.dto.ItemDto;
import com.example.itemapi.entity.Item;
import com.example.itemapi.commands.repository.ItemRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/item")
public class ItemController {

    private CommandGateway commandGataway;
    private ItemRepository itemRepository;

    @Autowired
    public ItemController(CommandGateway commandGataway, ItemRepository itemRepository) {
        this.commandGataway = commandGataway;
        this.itemRepository = itemRepository;
    }

    @PostMapping
    public String addItem(@RequestBody ItemDto itemDto) {

        CreateItemCommand createItemCommand =
                CreateItemCommand.builder()
                        .id(UUID.randomUUID().toString())
                        .name(itemDto.getName())
                        .build();

        String result = commandGataway.sendAndWait(createItemCommand);

        return result;
    }

}
