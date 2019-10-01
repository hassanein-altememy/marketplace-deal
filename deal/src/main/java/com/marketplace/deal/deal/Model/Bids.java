package com.marketplace.deal.deal.Model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Bids {
    private long id;
    private String userId;
    private double offer;
    private long adId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "user_id", nullable = false)
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "offer", nullable = false)
    public double getOffer() {
        return offer;
    }
    public void setOffer(double offer) {
        this.offer = offer;
    }

    @Column(name = "ad_id", nullable = false)
    public long getAdId() {
        return adId;
    }
    public void setAdId(long adId) {
        this.adId = adId;
    }

    @Override
    public String toString() {
        return "Bids{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", offer=" + offer +
                ", adId=" + adId +
                '}';
    }
}
