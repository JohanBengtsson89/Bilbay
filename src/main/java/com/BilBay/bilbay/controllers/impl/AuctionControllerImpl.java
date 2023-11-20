package com.BilBay.bilbay.controllers.impl;

import com.BilBay.bilbay.controllers.CrudController;
import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.serviceImpl.AuctionServiceImpl;
import com.BilBay.bilbay.services.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class AuctionControllerImpl implements CrudController<Auction> {

    @Autowired
    AuctionServiceImpl AuctionServiceImpl;

    @Override
    @GetMapping("auctions")
    public List<Auction> findAll() {
        return AuctionServiceImpl.findAll();
    }

    @Override
    @GetMapping("auctions/{id}")
    public Auction findById(@PathVariable Long id) {
        return AuctionServiceImpl.findById(id);
    }

    @Override
    @PostMapping("auctions/post-auction")
    public Auction create(@RequestBody Auction auction) {
        return AuctionServiceImpl.create(auction);
    }

    @Override
    public Auction update(Long id, Auction entity) {
        return null;
    }


    @Override
    public void delete(Long id) {

    }


    @GetMapping("auctions/{id}/highest-bid")
    public ResponseEntity<Bid> getHighestBid(@PathVariable Long id) {
        Bid highestBid = AuctionServiceImpl.getHighestBid(id);
        if (highestBid == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(highestBid);
    }
    @GetMapping("auctions/{id}/all-bids")
    public ResponseEntity<List<Bid>> getAllBids(@PathVariable Long id) {
        List<Bid> allBids = AuctionServiceImpl.getAllBids(id);
        if (allBids.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allBids);
    }

    @PutMapping("auth/auction/{id}/{isActive}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public String deActivateProductAuction (@PathVariable Long id, @PathVariable boolean isActive){
        AuctionServiceImpl.deactivateProductAuction(id, isActive);
        return "Auction has been deactivated";
    }
}

