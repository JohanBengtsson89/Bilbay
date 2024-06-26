package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

    List<Bid> findByAuctionIdOrderByBidAmountDesc(Long auctionId);
    List<Bid> findByAuctionId(Long auctionId);
    //List<Bid> findAllBidsByAuctionId(Long id);
}
