package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("")
    public String bidNotification(@RequestBody Bid bid){
        return "You have been outbidded";
    }

    /*@GetMapping("all-bids/{id}")
    public List<Bid> findAllBidsByAuction(@PathVariable Long id){
        return bidService.getAllBidsOnAuction(id.ge);
    }*/

}
