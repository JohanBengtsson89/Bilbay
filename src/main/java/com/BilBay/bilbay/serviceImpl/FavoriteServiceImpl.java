package com.BilBay.bilbay.serviceImpl;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Favorite;
import com.BilBay.bilbay.models.User;
import com.BilBay.bilbay.repositories.AuctionRepository;
import com.BilBay.bilbay.repositories.FavoriteRepository;
import com.BilBay.bilbay.repositories.UserRepository;
import com.BilBay.bilbay.services.FavoriteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final UserRepository userRepository;
    private final AuctionRepository auctionRepository;
    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteServiceImpl(FavoriteRepository favoriteRepository, UserRepository userRepository, AuctionRepository auctionRepository) {
        this.favoriteRepository = favoriteRepository;
        this.userRepository = userRepository;
        this.auctionRepository = auctionRepository;
    }

    @Override
    public ResponseEntity<Favorite> addFavorite(Long userId, Long auctionId) {
        User user = userRepository.findUserById(userId);
        Auction auction = auctionRepository.findAuctionById(auctionId);
        if (user == null || auction == null) {
            // Handle the case where the user or auction is not found
            return ResponseEntity.notFound().build();
        }

        Favorite favorite = new Favorite(user, auction);
        favorite = favoriteRepository.save(favorite);

        // Now, fetch the favorite with associated user and auction details
        Optional<Favorite> savedFavorite = favoriteRepository.findById(favorite.getId());
        return savedFavorite.map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @Override
    public List<Auction> getAllFavorites() {
        List<Favorite> favorites = favoriteRepository.findAll();
        List<Auction> allFavorites = new ArrayList<>();
        for (Favorite favorite : favorites) {
            allFavorites.add(favorite.getAuction());
        }
        return allFavorites;
    }

    @Override
    public List<Auction> getUsersFavoriteAuctions(Long userId) {
        List<Favorite> favorites = favoriteRepository.findByUserId(userId);

        return favorites.stream()
                .map(Favorite::getAuction)
                .toList();
    }

    @Override
    @Transactional
    public void removeFromFavorite(Long userId, Long auctionId) {
        favoriteRepository.deleteByUserIdAndAuctionId(userId, auctionId);
    }
}