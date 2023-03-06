package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

    Bid bidNotifcation (String Notification);

    //List<Bid> findAllBidsByAuctionId(Long id);
}
