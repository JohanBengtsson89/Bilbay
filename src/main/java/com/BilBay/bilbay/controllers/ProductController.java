package com.BilBay.bilbay.controllers;
import com.BilBay.bilbay.models.Product;
import com.BilBay.bilbay.repositories.ProductRepository;
import com.BilBay.bilbay.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping("/api/")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("auth/product")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public Product registerProduct(@RequestBody Product product) {
        return productService.registerProduct(product);
    }
    @GetMapping("product/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }
    @GetMapping("products")
    public List<Product> searchProducts(@RequestParam("query") String query){
        return productService.searchProducts(query);
    }
    @GetMapping("available-products/{isAvailable}")
    public List<Product> findByIsAvailable(@PathVariable boolean isAvailable){
        return productService.findByIsAvailable(isAvailable);
    }
    @DeleteMapping("auth/product/delete/{id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public String deleteById(@PathVariable Long id){
            productService.deleteProduct(id);
            return "Product has been deleted.";
        }

    
    @PutMapping("auth/product/{id}/{isAvailable}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public String updateProductStatus (@PathVariable Long id, @PathVariable boolean isAvailable) {
        if (!productRepository.findById(id).isEmpty()){
            productService.updateProductStatus(id, isAvailable);
            return "Product status has been updated.";
        }
        return "Product not found";
    }
}

