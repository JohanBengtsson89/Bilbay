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
    public List<Product> searchProducts(String query){
        return productRepository.searchProducts(query);
    }
    public List<Product> findByIsAvailable(boolean isAvailable){
            return productRepository.findAllByIsAvailable(isAvailable);
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}