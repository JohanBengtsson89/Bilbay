package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class BidController {

    @Autowired
    BidService bidService;

    @PostMapping("bid")
    public Bid createBid(@RequestBody Bid bid) {
        return bidService.createBid(bid);
    }

    @GetMapping("bid/{id}")
    public Bid getBidById(@PathVariable Long id) {
        return bidService.getBidByID(id);
    }

    @GetMapping("all-bids/{id}")
    public List<Bid> findAllBidsByAuction(@PathVariable Auction auction){
        return bidService.findAllBidsByAuction(auction.getId());
    }

}
