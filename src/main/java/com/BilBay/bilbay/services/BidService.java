package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.Bid;

public interface BidService {
    Bid createBid(Bid bid);

    Bid getBidByID(Long id);
}
