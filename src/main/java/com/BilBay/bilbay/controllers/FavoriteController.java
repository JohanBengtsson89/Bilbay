package com.BilBay.bilbay.controllers;


import com.BilBay.bilbay.models.Favorite;
import com.BilBay.bilbay.models.Product;
import com.BilBay.bilbay.models.User;
import com.BilBay.bilbay.repositories.UserRepository;
import com.BilBay.bilbay.services.FavoriteService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private UserRepository userRepository;


    @PostMapping("auth/favorite/{user_id}/{product_id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    Favorite addFavorite(@PathVariable @NotNull Long user_id, @PathVariable @NotNull Long product_id) {
        return favoriteService.addFavorite(user_id, product_id);
    }

    @GetMapping("auth/getFavorites")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    Map<User, List<Product>> getAllFavorites() {
        return favoriteService.getAllFavorites();
    }
    @GetMapping("auth/favorite/{user_id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    List<Product> getUsersFavorites(@PathVariable Long user_id) {
        return favoriteService.getUsersFavorites(user_id);
    }
}
