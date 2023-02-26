package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p JOIN p.productSpecification s WHERE s.color LIKE CONCAT('%',:query, '%') " +
            "or s.gear LIKE CONCAT ('%',:query, '%')" +
            "or s.enginePower LIKE CONCAT ('%',:query, '%')" +
            "or p.productName LIKE CONCAT ('%',:query, '%')" +
            "or p.category LIKE CONCAT ('%',:query, '%')")
    List<Product> searchProducts(String query);

}
