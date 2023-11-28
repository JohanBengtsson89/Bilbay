package com.BilBay.bilbay.dto;

import com.BilBay.bilbay.models.Bid;
import java.time.LocalDate;

public class BidDto {
    private Long id;
    private Long buyerId;
    private Long auctionId;
    private Long bidAmount;
    private LocalDate createdAt;

    public BidDto() {
    }

    //Convert entity (Bid class) to Dto (BidDto class)
    public static BidDto toDto(Bid bid) {
        BidDto bidDto = new BidDto();
        bidDto.setId(bid.getId());
        bidDto.setBidAmount(bid.getBidAmount());
        bidDto.setCreatedAt(bid.getCreatedAt());

        if (bid.getBuyer() != null) {
            bidDto.setBuyerId(bid.getBuyer().getId());
        }

        if (bid.getAuction() != null) {
            bidDto.setAuctionId(bid.getAuction().getId());
        }

        return bidDto;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getBuyerId() {
        return buyerId;
    }
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
    public Long getAuctionId() {
        return auctionId;
    }
    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }
    public Long getBidAmount() {
        return bidAmount;
    }
    public void setBidAmount(Long bidAmount) {
        this.bidAmount = bidAmount;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
