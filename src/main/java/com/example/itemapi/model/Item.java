package com.example.itemapi.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;


@Data
@Builder
public class Item {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;

}
