package com.example.itemapi.aggregate;

import com.example.itemapi.commands.CreateItemCommand;
import com.example.itemapi.event.ItemCreated;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Aggregate
public class ItemAggregate {

    @AggregateIdentifier
    private UUID id;
    private String name;

    @CommandHandler
    public ItemAggregate(CreateItemCommand createItemCommand) {

        ItemCreated itemCreated = new ItemCreated();

        BeanUtils.copyProperties(createItemCommand,itemCreated);

        AggregateLifecycle.apply(itemCreated);
    }

    public ItemAggregate() {
    }

    @EventSourcingHandler
    public void on(ItemCreated itemCreated){
        this.id = itemCreated.getId();
        this.name = itemCreated.getName();
    }
}
