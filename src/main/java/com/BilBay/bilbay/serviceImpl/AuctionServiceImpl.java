package com.BilBay.bilbay.serviceImpl;

import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.models.User;
import com.BilBay.bilbay.repositories.AuctionRepository;
import com.BilBay.bilbay.repositories.BidRepository;
import com.BilBay.bilbay.services.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService<Auction> {

    @Autowired
    AuctionRepository auctionRepository;
    @Autowired
    BidRepository bidRepository;
    @Override
    public Auction create(Auction auction) {
        return auctionRepository.save(auction);
    }

    public Auction createWithBuilder (Auction auction) {
        Auction newAuction = new Auction.Builder(auction.getUser(), auction.getProductName(), auction.getCategory(), auction.getStartPrice(), auction.getStartTime(), auction.getEndTime())
                .gear(auction.getGear())
                .mileage(auction.getMileage())
                .enginPower(auction.getEnginePower())
                .active(auction.isActive())
                .reservePrice(auction.getReservePrice())
                .productPhoto(auction.getProductPhoto())
                .vinNr(auction.getVinNr())
                .modelYear(auction.getModelYear())
                .originalPrice(auction.getOriginalPrice())
                .color(auction.getColor())
                .build();

        return auctionRepository.save(newAuction);
    }
    @Override
    public Auction findById(Long id) {
        return auctionRepository.findById(id).get();
    }

    @Override
    public List<Auction> findAll() {
        return auctionRepository.findAll();
    }

    public AuctionServiceImpl(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public void deactivateProductAuction(Long id, boolean isActive){
        auctionRepository.deactivateProductAuction(isActive, id);
    }

    public Bid getHighestBid(Long auctionId) {
        List<Bid> bids = bidRepository.findByAuctionIdOrderByBidAmountDesc(auctionId);
        if (bids.isEmpty()) {
            return null;
        }
        return bids.get(0);
    }

    public List<Bid> getAllBids(Long auctionId) {
        return bidRepository.findByAuctionId(auctionId);
    }

}
