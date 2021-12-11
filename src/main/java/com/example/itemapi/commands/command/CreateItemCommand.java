package com.example.itemapi.commands.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateItemCommand {

    @TargetAggregateIdentifier
    private String id;
    private String name;
}
