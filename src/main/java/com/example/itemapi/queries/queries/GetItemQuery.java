package com.example.itemapi.queries.queries;

import lombok.Data;

@Data
public class GetItemQuery {

    private String id;

    public GetItemQuery(String id) {
        this.id = id;
    }

}
