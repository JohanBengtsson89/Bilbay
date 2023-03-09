package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface AuctionRepository extends JpaRepository<Auction, Long> {

    //List<Bid> findAuctionById (Long Id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Auction u SET u.active = ?1 WHERE u.id = ?2")
    void deactivateProductAuction (Long id, boolean isActive);
}

