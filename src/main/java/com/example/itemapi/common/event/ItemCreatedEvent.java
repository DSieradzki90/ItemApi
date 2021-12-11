package com.example.itemapi.common.event;

public class ItemCreatedEvent extends BaseEvent<String>{

    private final String id;

    public ItemCreatedEvent(String id, String id1) {
        super(id);
        this.id = id1;
    }

    public String getId(){
        return id;
    }
}
