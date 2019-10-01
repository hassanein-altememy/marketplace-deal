package com.marketplace.deal.deal.repository;


import com.marketplace.deal.deal.Model.Bids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BidsRepository extends JpaRepository<Bids, Long>{

}