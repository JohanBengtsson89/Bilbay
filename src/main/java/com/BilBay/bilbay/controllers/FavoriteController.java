package com.BilBay.bilbay.controllers;


import com.BilBay.bilbay.models.Favorite;
import com.BilBay.bilbay.models.Product;
import com.BilBay.bilbay.models.User;
import com.BilBay.bilbay.repositories.UserRepository;
import com.BilBay.bilbay.services.FavoriteService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/favorite/")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/{user_id}/{product_id}")
    Favorite addFavorite(@PathVariable @NotNull Long user_id, @PathVariable @NotNull Long product_id) {
        return favoriteService.addFavorite(user_id, product_id);
    }

    @GetMapping("getFavorites")
    Map<User, List<Product>> getAllFavorites() {
        return favoriteService.getAllFavorites();
    }
    @GetMapping("{user_id}")
    List<Product> getUsersFavorites(@PathVariable Long user_id) {
        return favoriteService.getUsersFavorites(user_id);
    }
}
