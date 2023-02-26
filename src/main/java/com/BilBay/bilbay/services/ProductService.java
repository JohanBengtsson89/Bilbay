package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.Product;
import com.BilBay.bilbay.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Product> findByProductNameOrColor(String productName, String color) {
        return productRepository.findAllByProductNameOrProductSpecificationColor(productName, color);
    }
    public List<Product> findByCategoryOrModelYear(String category, int modelYear){
        return productRepository.findAllByCategoryOrProductSpecificationModelYear(category,modelYear);
    }

}