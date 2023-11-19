package com.BilBay.bilbay.serviceImpl;

import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.repositories.BidRepository;
import com.BilBay.bilbay.services.BidService;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImpl implements BidService {
    private BidRepository bidRepository;
    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public Bid placeBid(Bid bid) {
        return bidRepository.save(bid);
    }

    @Override
    public Bid getBid(Long id) {
        return bidRepository.findById(id).get();
    }
}
