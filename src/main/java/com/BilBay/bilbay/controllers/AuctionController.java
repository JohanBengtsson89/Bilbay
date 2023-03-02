package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.models.Product;
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

    @GetMapping("search-highestBid")
    public List<Auction> searchHighestBid(@RequestParam("query") String query){
        return auctionService.searchHighestBid(query);  }

    @GetMapping("search-bidDate")
    public List<Auction> searchBidDate(@RequestParam("query") String query){
        return auctionService.searchBidDate(query);

    }

}
