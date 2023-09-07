package org.example.service;

import org.example.data.model.ProductType;
import org.example.data.repo.AdminRepo;
import org.example.data.repo.ProductRepo;
import org.example.dto.AdminRequest;
import org.example.dto.ProductRequest;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import  static org.hamcrest.CoreMatchers.is;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminServiceImplTest {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private  ProductService productService;
    @Autowired
    private ProductRepo productRepo;
    @Test
    public void testToAddAmin(){
        AdminRequest request = new AdminRequest();
        request.setPassword("12345");
        request.setFirstName("Josh");
        request.setLastName("Ayomide");
        request.setUserName("josh123");
        adminService.registerNewUser(request);
        assertThat(adminRepo.count(),is(3L));
    }
    @Test
    public void testToMultipleAddAmin(){
        AdminRequest request = new AdminRequest();
        request.setPassword("12345");
        request.setFirstName("Josh");
        request.setLastName("Ayomide");
        request.setUserName("josh12");
        adminService.registerNewUser(request);

        AdminRequest request1 = new AdminRequest();
        request1.setPassword("12345");
        request1.setFirstName("Josh");
        request1.setLastName("Ayomide");
        request1.setUserName("josh128");
        adminService.registerNewUser(request1);
        assertThat(adminRepo.count(),is(3L));
    }
    @Test
    public void testThatUserCanLogin(){
        AdminRequest request = new AdminRequest();
        request.setPassword("12345");
        request.setUserName("josh12");
        var user =adminService.login(request);
        assertThat(user.getFirstName(),is("Josh"));
    }
    @Test
    public  void testToAddProducts(){
        AdminRequest request = new AdminRequest();
        request.setPassword("12345");
        request.setUserName("josh12");
        var admin = adminService.login(request);

        ProductRequest request1 = new ProductRequest();
        request1.setName("Guitar");
        request1.setType(ProductType.MUSICAL);
        request1.setAdmin(admin);
        request1.setPrice(BigInteger.valueOf(2000));
        request1.setQuantity(5);
        productService.addProduct(request1);
        assertThat(productRepo.count(), Is.is(1L));
    }
    @Test
    public  void testToUpdateProducts(){
        AdminRequest request = new AdminRequest();
        request.setPassword("12345");
        request.setUserName("josh12");
        var admin = adminService.login(request);

        ProductRequest request1 = new ProductRequest();
        request1.setName("Guitar");
        request1.setType(ProductType.MUSICAL);
        request1.setAdmin(admin);
        request1.setPrice(BigInteger.valueOf(2000));
        request1.setQuantity(5);
        productService.addProduct(request1);
        assertThat(productRepo.count(), Is.is(1L));
    }
}