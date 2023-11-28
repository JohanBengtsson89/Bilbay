package com.BilBay.bilbay.controllers.impl;

import com.BilBay.bilbay.controllers.CrudController;
import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.serviceImpl.AuctionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/auth")
public class AuctionControllerImpl implements CrudController<Auction> {

    @Autowired
    AuctionServiceImpl auctionServiceImpl;

    @Override
    @GetMapping("auctions")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public List<Auction> findAll() {
        return auctionServiceImpl.findAll();
    }
    @Override
    @GetMapping("auctions/{id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public Auction findById(@PathVariable Long id) {
        return auctionServiceImpl.findById(id);
    }

    @Override
    @PostMapping("auctions/post-auction")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public Auction create(@RequestBody Auction auction) {
        return auctionServiceImpl.create(auction);
    }
    //New endpoint for builder pattern
    @PostMapping("auctions/new-auction")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public Auction build (@RequestBody Auction auction) {
        return auctionServiceImpl.createWithBuilder(auction);
    }

    @GetMapping("auctions/{id}/highest-bid")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public ResponseEntity<Bid> getHighestBid(@PathVariable Long id) {
        Bid highestBid = auctionServiceImpl.getHighestBid(id);
        if (highestBid == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(highestBid);
    }
    @GetMapping("auctions/{id}/all-bids")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public ResponseEntity<List<Bid>> getAllBids(@PathVariable Long id) {
        List<Bid> allBids = auctionServiceImpl.getAllBids(id);

        if (allBids.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allBids);
    }
    @PostMapping("post-auction")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public Auction createAuction (@RequestBody Auction auction) {
        return auctionServiceImpl.create(auction);
    }

    @PutMapping("auth/auction/{id}/{isActive}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public String deActivateProductAuction (@PathVariable Long id, @PathVariable boolean isActive){
        auctionServiceImpl.deactivateProductAuction(id, isActive);
        return "Auction has been deactivated";
    }
}

