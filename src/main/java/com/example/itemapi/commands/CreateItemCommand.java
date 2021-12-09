package com.example.itemapi.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
@Builder
public class CreateItemCommand {

    @TargetAggregateIdentifier
    private UUID id;
    private String name;
}
