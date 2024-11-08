package org.ayrotek.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {

    private String name;
    private String description;
    private Double price;
    private Double tax;
}
