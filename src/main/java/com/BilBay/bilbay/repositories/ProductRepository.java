package com.BilBay.bilbay.repositories;
import com.BilBay.bilbay.models.Favorite;
import com.BilBay.bilbay.models.Product;
import com.BilBay.bilbay.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    List<Product> findAllByIsAvailable(boolean isAvailable);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Product u SET u.isAvailable = ?1 where u.id = ?2")
    void updateProductStatus(boolean isAvailable, Long id);
    @Transactional
    void deleteProductById(Long id);

    Product findProductById(Long id);


}
