package com.example.itemapi.queries.controller;

import com.example.itemapi.entity.Item;
import com.example.itemapi.queries.queries.GetItemQuery;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/item")
public class ItemQueryController {

    private QueryGateway queryGateway;

    public ItemQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/getItem")
    public ResponseEntity<Item> getItem(@RequestParam String id) {
        Item item = queryGateway.query(
                        new GetItemQuery(id), Item.class)
                .join();

        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
}