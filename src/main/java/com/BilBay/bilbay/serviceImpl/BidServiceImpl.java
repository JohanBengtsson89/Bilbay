package com.BilBay.bilbay.serviceImpl;

import com.BilBay.bilbay.dto.BidDto;
import com.BilBay.bilbay.models.Auction;
import com.BilBay.bilbay.models.Bid;
import com.BilBay.bilbay.models.User;
import com.BilBay.bilbay.repositories.BidRepository;
import com.BilBay.bilbay.services.BidService;
import com.BilBay.bilbay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    BidRepository bidRepository;
    @Autowired
    AuctionServiceImpl auctionServiceImpl;
    @Autowired
    UserService userService;

    @Override
    public BidDto createBid(BidDto bidDto) {
        User buyer = userService.findUserById(bidDto.getBuyerId());
        Auction auction = auctionServiceImpl.findById(bidDto.getAuctionId());
        Bid bid = new Bid();
        // Save the bid only if both buyer and auction are available
        if (buyer != null && auction != null) {
            bid.setAuction(auction);
            bid.setBuyer(buyer);
            bid.setBidAmount(bidDto.getBidAmount());
            bid.setCreatedAt(bidDto.getCreatedAt());
            Bid savedBid = bidRepository.save(bid);
            return BidDto.toDto(savedBid);

        } else {
            throw new IllegalArgumentException("Bid or buyer does not exist");
        }
    }

    @Override
    public BidDto getBidByID(Long id) {
        Bid bid = bidRepository.findById(id).orElse(null);
        if (bid == null) {
            throw new IllegalArgumentException("Bid does not exist");
        }

        return BidDto.toDto(bid);
    }
}
