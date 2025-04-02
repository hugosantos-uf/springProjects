package com.studys.restapi;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private Long id;
    private String name;
    private Double price;
}
