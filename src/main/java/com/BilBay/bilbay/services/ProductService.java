package com.BilBay.bilbay.services;
import com.BilBay.bilbay.models.Product;
import com.BilBay.bilbay.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product registerProduct(Product product){
        return productRepository.save(product);
    }
    public Product findProductById(Long id){
        return productRepository.findById(id).get();
    }
    public List<Product> searchProducts(String query){
        return productRepository.searchProducts(query);
    }
    public List<Product> findByIsAvailable(boolean isAvailable){
            return productRepository.findAllByIsAvailable(isAvailable);
    }
    public void deleteProduct(Long id){
        productRepository.deleteProductById(id);
    }
    public void updateProductStatus(Long id, boolean isAvailable){
        productRepository.updateProductStatus(isAvailable, id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}