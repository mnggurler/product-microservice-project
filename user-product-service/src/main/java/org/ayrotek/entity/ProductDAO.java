package org.ayrotek.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Data
public class ProductDAO {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String description;
    private Double price;
    private Double tax;
}
