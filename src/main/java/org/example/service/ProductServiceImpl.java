package org.example.service;

import org.example.data.model.Product;
import org.example.data.repo.ProductRepo;
import org.example.dto.ProductRequest;
import org.example.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepo productRepo;
    @Override
    public void addProduct(ProductRequest request) {
        DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Product product = new Product();
        product.setName(request.getName());
        product.setType(request.getType());
        product.setPrice(request.getPrice());
        product.setAdmin(request.getAdmin());
        product.setDateAdded(LocalDateTime.now().format(formatter));
        product.setQuantity(request.getQuantity());
        product.setId(request.getId());
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(ProductRequest request) {
        var ans =productRepo.findById(request.getId()).isPresent();
        if(ans)productRepo.delete(productRepo.findById(request.getId()).get());
    }

    @Override
    public Product searchProductByName(Product request) {
        var ans = productRepo.findByName(request.getName()).isPresent();
        if(ans){
        return productRepo.findByName(request.getName()).get();}
        throw new ProductNotFoundException("Item not found");
    }

    @Override
    public List<Product> displayAllProduct() {
        if(productRepo.count() > 0){
            return productRepo.findAll();}
        throw new ProductNotFoundException("Please Add Product, no Product found");
    }

    @Override
    public Product searchId(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public void updateProduct(ProductRequest request) {
        var checkProduct = productRepo.findById(request.getId());
        if(checkProduct.isPresent()){
            var product = checkProduct.get();
            DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            product.setName(request.getName());
            product.setType(request.getType());
            product.setDateUpdated(LocalDateTime.now().format(formatter));
            product.setQuantity(request.getQuantity());
            product.setId(request.getId());
            productRepo.save(product);
        }
    }
}
