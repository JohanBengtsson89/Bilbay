package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {

    //List<Bid> findAuctionById (Long Id);

}
