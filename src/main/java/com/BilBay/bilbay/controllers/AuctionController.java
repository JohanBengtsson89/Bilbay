package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.models.Product;
import com.BilBay.bilbay.services.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuctionController {

    @Autowired
    AuctionService auctionService;

    @GetMapping("auction/{id}")
    public Auction findAuctionById (@PathVariable Long id){
        return auctionService.findAuctionById(id);
    }

    @GetMapping("{auctionId}/highest-bid")
    public ResponseEntity<Bid> getHighestBid(@PathVariable Long auctionId) {
        Bid highestBid = auctionService.getHighestBid(auctionId);
        if (highestBid == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(highestBid);
    }

    @PostMapping("post-auction")
    public Auction createAuction (@RequestBody Auction auction) {
        return auctionService.createAuction(auction);
    }

    @DeleteMapping("auc/{id}")
    public String deleteById(@PathVariable Long id){
        auctionService.deleteAuctionById(id);
        return "auction and all bids has been deleted.";
    }
}

