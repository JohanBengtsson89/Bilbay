package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

    // HashSet<Bid> getAuctionBids(Auction auction);

}
