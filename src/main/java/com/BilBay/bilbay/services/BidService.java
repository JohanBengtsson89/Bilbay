package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.Bid;

public interface BidService {
    Bid placeBid(Bid bid);

    Bid getBid(Long id);

}
