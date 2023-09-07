package org.example.service;

import org.example.data.model.Admin;
import org.example.data.model.Product;
import org.example.data.model.User;
import org.example.dto.AdminRequest;
import org.example.dto.ProductRequest;
import org.example.dto.UserRequest;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    void registerNewUser(AdminRequest request);
    Admin login(AdminRequest request);
    void addProducts(ProductRequest request);
    void deleteProducts(ProductRequest request);
    void updateProducts(ProductRequest request);
    List<Product>showAllProducts();
}
