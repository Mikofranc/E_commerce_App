package org.example.dto;

import lombok.Data;
import org.example.data.model.Admin;
import org.example.data.model.ProductType;

import java.math.BigInteger;

@Data
public class ProductRequest {
    private int id;
    private String name;
    private ProductType type;
    private int quantity;
    private String dateAdded;
    private String datePurchased;
    private BigInteger price;
    private Admin admin;

}
