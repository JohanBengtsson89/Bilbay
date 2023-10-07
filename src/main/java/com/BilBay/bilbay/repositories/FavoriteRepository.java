package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.Favorite;
import com.BilBay.bilbay.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUserId(Long id);

    void deleteByUserIdAndAuctionId(Long userId, Long auctionId);
}