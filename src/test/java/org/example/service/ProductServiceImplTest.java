package org.example.service;

import org.example.data.model.ProductType;
import org.example.data.repo.ProductRepo;
import org.example.dto.ProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private  ProductService productService;
    @Autowired
    private ProductRepo productRepo;
    @Test
    public void testToAddProduct(){
        ProductRequest request = new ProductRequest();
        request.setName("Guitar");
        request.setType(ProductType.MUSICAL);
        request.setPrice(BigInteger.valueOf(2000));
        request.setQuantity(5);
        productService.addProduct(request);
        assertThat(productRepo.count(),is(1L));
    }
    @Test
    public void testToAddMultipleProduct(){
        ProductRequest request = new ProductRequest();
        request.setName("Bulb");
        request.setType(ProductType.ELECTRICAL);
        request.setPrice(BigInteger.valueOf(8000));
        request.setQuantity(10);
        productService.addProduct(request);

        ProductRequest request1 = new ProductRequest();
        request1.setName("Fan");
        request1.setType(ProductType.ELECTRICAL);
        request1.setPrice(BigInteger.valueOf(10_000));
        request1.setQuantity(2);
        productService.addProduct(request1);
        assertThat(productRepo.count(),is(3L));
    }
    @Test
    public void testToUpdateProduct(){
        ProductRequest request = new ProductRequest();
        request.setId(1);
        request.setName("Guitar Ibanaze");
        request.setType(ProductType.MUSICAL);
        request.setPrice(BigInteger.valueOf(2000));
        request.setQuantity(5);
        productService.updateProduct(request);
        assertThat(productRepo.count(),is(1L));
    }
    @Test
    public void testToDeleteProduct(){
        ProductRequest request = new ProductRequest();
        request.setId(1);
        productService.deleteProduct(request);
        assertThat(productRepo.count(),is(2L));
    }
    @Test
    public void testToDisplayAllProducts(){
        var products = productService.displayAllProduct();
        System.out.println(products);
    }

}