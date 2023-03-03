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
    @GetMapping("available-products/{isAvailable}")
    public List<Product> findByIsAvailable(@PathVariable boolean isAvailable){
        return productService.findByIsAvailable(isAvailable);
    }
    @DeleteMapping("delete-product/{id}")
    public String deleteById(@PathVariable Long id){
        productService.deleteProduct(id);
        return "product has been deleted";
    }
    @PutMapping("{id}/{isAvailable}")
    public void updateProductStatus (@PathVariable Long id, @PathVariable boolean isAvailable) {
        productService.updateProductStatus(id, isAvailable);
    }
}

