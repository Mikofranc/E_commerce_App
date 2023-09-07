package org.example.data.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private String name;
    private ProductType type;
    private int quantity;
    private String dateAdded;
    private String datePurchased;
    private String dateUpdated;
    private BigInteger price;
    @ManyToOne
    private Admin admin;
}
