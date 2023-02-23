package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.Product;
import com.BilBay.bilbay.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}