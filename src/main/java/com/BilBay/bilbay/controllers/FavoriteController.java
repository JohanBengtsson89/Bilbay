package com.BilBay.bilbay.controllers;


import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Favorite;
import com.BilBay.bilbay.repositories.UserRepository;
import com.BilBay.bilbay.services.FavoriteService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("favorite/{user_id}/{auction_id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    Favorite addToFavorite(@PathVariable @NotNull Long user_id, @PathVariable @NotNull Long auction_id) {
        return favoriteService.addFavorite(user_id, auction_id).getBody();
    }

    @GetMapping("getFavorites")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    List<Auction> getAllFavorites() {
        return favoriteService.getAllFavorites();
    }

    @GetMapping("favorite/{user_id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    List<Auction> getUsersFavoriteAuctions(@PathVariable Long user_id) {
        return favoriteService.getUsersFavoriteAuctions(user_id);
    }

    @DeleteMapping("delete-favorite/{user_id}/{auction_id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    ResponseEntity<String> removeFromFavorite(@PathVariable @NotNull Long user_id, @PathVariable @NotNull Long auction_id) {
        favoriteService.removeFromFavorite(user_id, auction_id);
        return ResponseEntity.ok("Favorite removed successfully");
    }

//    @PostMapping("auth/favorite/{user_id}/{product_id}")
//    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
//    Favorite addFavorite(@PathVariable @NotNull Long user_id, @PathVariable @NotNull Long product_id) {
//        return favoriteService.addFavorite(user_id, product_id);
//    }

//    @GetMapping("auth/getFavorites")
//    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
//    Map<User, List<Product>> getAllFavorites() {
//        return favoriteService.getAllFavorites();
//  }
//    @GetMapping("auth/favorite/{user_id}")
//    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
//    List<Product> getUsersFavorites(@PathVariable Long user_id) {
//        return favoriteService.getUsersFavorites(user_id);
//    }

}