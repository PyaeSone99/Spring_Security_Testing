package com.example.prepostfilter.ds;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String name;
    private String owner;

    public Product(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }
}
