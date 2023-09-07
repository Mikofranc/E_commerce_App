package org.example.service;

import org.example.data.model.Product;
import org.example.dto.ProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void addProduct(ProductRequest request);
    void deleteProduct(ProductRequest request);
    Product searchProductByName(Product request);
    List<Product> displayAllProduct();
    Product searchId(int id);
    void updateProduct(ProductRequest request);
}
