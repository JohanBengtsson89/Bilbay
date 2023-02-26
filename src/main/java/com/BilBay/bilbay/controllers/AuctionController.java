package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.services.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuctionController {

    @Autowired
    AuctionService auctionService;

    /*@GetMapping("get-all-bids/{id}")
    public List<Bid> findAllBidsOnAuction(Long id){
        return auctionService.findAllBidsOnAuction(id);
    }*/

}
