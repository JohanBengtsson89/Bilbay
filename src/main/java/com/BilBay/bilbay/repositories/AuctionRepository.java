package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface AuctionRepository extends JpaRepository<Auction, Long> {

    List<Auction> searchHighestBid(String query);

    List<Auction> searchBidDate(String query);

    //List<Bid> findAuctionById (Long Id);

}
