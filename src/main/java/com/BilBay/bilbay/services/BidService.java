package com.BilBay.bilbay.services;

import com.BilBay.bilbay.dto.BidDto;

public interface BidService {

    BidDto createBid(BidDto bidDTO);
    BidDto getBidByID(Long id);
}