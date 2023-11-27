package com.BilBay.bilbay.controllers;

import com.BilBay.bilbay.dto.BidDto;
import com.BilBay.bilbay.serviceImpl.BidServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth/")
public class BidController {

    @Autowired
    BidServiceImpl bidServiceImpl;

    @PostMapping("bid")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public BidDto createBid(@RequestBody BidDto bidDTO) {
        return bidServiceImpl.createBid(bidDTO);
    }

    @GetMapping("bid/{id}")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    public BidDto getBidById(@PathVariable Long id) {
        return bidServiceImpl.getBidByID(id);
    }

//    @GetMapping("find-highestBid")
//    public Bid findByHighestAmountAndDate(@RequestParam("query") String query){
//        return bidService.findByHighestAmountAndDate(query);  }

    /*@GetMapping("all-bids/{id}")
    public List<Bid> findAllBidsByAuction(@PathVariable Long id){
        return bidService.getAllBidsOnAuction(id.ge);
    }*/

}
