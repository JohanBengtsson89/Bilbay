package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Favorite;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FavoriteService {
    ResponseEntity<Favorite> addFavorite(Long userId, Long auctionId);
    List<Auction> getAllFavorites();
    List<Auction> getUsersFavoriteAuctions(Long userId);
    void removeFromFavorite(Long userId, Long auctionId);

}
