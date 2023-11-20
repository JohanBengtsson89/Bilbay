package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.repositories.AuctionRepository;
import com.BilBay.bilbay.models.Product;
import com.BilBay.bilbay.services.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/auth/")
public class AuctionController {

    @Autowired
    AuctionService auctionService;

    @GetMapping("auctions")
    public List<Auction> findAllAuctions() {
        return auctionService.findAllAuctions();
    }
    @GetMapping("auction/{id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public Auction findAuctionById (@PathVariable Long id){
        return auctionService.findAuctionById(id);
    }

    @GetMapping("{auctionId}/highest-bid")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public ResponseEntity<Bid> getHighestBid(@PathVariable Long auctionId) {
        Bid highestBid = auctionService.getHighestBid(auctionId);
        if (highestBid == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(highestBid);
    }
    @GetMapping("{auctionId}/all-bids")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public ResponseEntity<List<Bid>> getAllBids(@PathVariable Long auctionId) {
        List<Bid> allBids = auctionService.getAllBids(auctionId);
        if (allBids.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allBids);
    }

    @PostMapping("post-auction")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public Auction createAuction (@RequestBody Auction auction) {
        return auctionService.createAuction(auction);}

    @PutMapping("auth/auction/{id}/{isActive}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public String deActivateProductAuction (@PathVariable Long id, @PathVariable boolean isActive){
        auctionService.deactivateProductAuction(id, isActive);
        return "Auction has been deactivated";
    }


}

