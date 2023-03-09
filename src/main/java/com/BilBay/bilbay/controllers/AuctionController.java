package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.repositories.AuctionRepository;
import com.BilBay.bilbay.services.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("post-auction")
    public Auction createAuction (@RequestBody Auction auction) {
        return auctionService.createAuction(auction);}

    @PutMapping("{id}/{isActive}")
    public String deActivateProductAuction (@PathVariable Long id, @PathVariable boolean isActive){
        auctionService.deactivateProductAuction(id, isActive);
        return "Auction has been deactivated";
    }

}
