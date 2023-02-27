package com.BilBay.bilbay.controllers;
import com.BilBay.bilbay.models.Product;
import com.BilBay.bilbay.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping("/")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("post-product")
    public Product registerProduct(@RequestBody Product product) {
        return productService.registerProduct(product);
    }
    @GetMapping("product-id/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }
    @GetMapping("search-products")
    public List<Product> searchProducts(@RequestParam("query") String query){
        return productService.searchProducts(query);
    }
}

