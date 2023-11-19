package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/")
public class BidController {

    @Autowired
    private BidService bidService;

    public BidController(BidService bidService) { this.bidService = bidService;}

    @PostMapping("bid")
    public Bid createBid(@RequestBody Bid bid) {
        return bidService.placeBid(bid);
    }

    @GetMapping("auth/bid/{id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public Bid getBidById(@PathVariable Long id) {
        return bidService.getBid(id);
    }

//    @GetMapping("find-highestBid")
//    public Bid findByHighestAmountAndDate(@RequestParam("query") String query){
//        return bidService.findByHighestAmountAndDate(query);  }

    /*@GetMapping("all-bids/{id}")
    public List<Bid> findAllBidsByAuction(@PathVariable Long id){
        return bidService.getAllBidsOnAuction(id.ge);
    }*/

}
