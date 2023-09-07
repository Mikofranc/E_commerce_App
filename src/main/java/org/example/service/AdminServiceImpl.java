package org.example.service;

import org.example.data.model.Admin;
import org.example.data.model.Product;
import org.example.data.model.Roles;
import org.example.data.repo.AdminRepo;
import org.example.dto.AdminRequest;
import org.example.dto.ProductRequest;
import org.example.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
@Service
public class AdminServiceImpl implements  AdminService{
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private ProductService productService;
    @Override
    public void registerNewUser(AdminRequest request) {
        Admin admin = new Admin();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        admin.setUserName(request.getUserName());
        request.setRoles(Roles.ADMIN);
        admin.setRoles(request.getRoles());
        admin.setFirstName(request.getFirstName());
        admin.setLastName(request.getLastName());
        admin.setPassword(request.getPassword());
        admin.setCreatedDate(LocalDateTime.now().format(formatter));
        adminRepo.save(admin);
    }

    @Override
    public Admin login(AdminRequest request) {
        var username = adminRepo.findByUserName(request.getUserName());
        boolean passwordCheck = username.get().getPassword().equals(request.getPassword());
        if(username.isPresent() && passwordCheck){
            username.get().setLoggedIn(true);
            return username.get();
        }throw new UserNotFoundException("Invalid Input");
    }

    @Override
    public void addProducts(ProductRequest request) {
        Admin admin = new Admin();
        if (admin.isLoggedIn()){
            productService.addProduct(request);
        }
    }

    @Override
    public void deleteProducts(ProductRequest request) {
        Admin admin = new Admin();
        if (admin.isLoggedIn()){
            productService.deleteProduct(request);
        }
    }

    @Override
    public void updateProducts(ProductRequest request) {

    }

    @Override
    public List<Product> showAllProducts() {
        return null;
    }
}
