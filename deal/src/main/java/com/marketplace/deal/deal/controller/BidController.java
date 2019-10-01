package com.marketplace.deal.deal.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.marketplace.deal.deal.Model.Bids;
import com.marketplace.deal.deal.repository.BidsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BidController {

    @Autowired
    private BidsRepository bidsRepository;

    @GetMapping("/bid")
    public List <Bids> getAllBidsByAdId(@RequestParam long id) {
        System.out.println("hello ");
        return bidsRepository.findAll().stream().filter(b-> b.getAdId()==id).collect(Collectors.toList());
    }

    /*@GetMapping("/bids/{id}")
    public ResponseEntity <Bids> getEmployeeById(@PathVariable(value = "id") Long adId)
            throws ResourceNotFoundException {
        Bids bids = bidsRepository.findById(adId)
                .orElseThrow(() -> new ResourceNotFoundException("Bids not found for this id :: " + adId));
        return ResponseEntity.ok().body(bids);
    }*/

    @PostMapping("/bid")
    public Bids createBid(@RequestBody Bids bids) {
        System.out.println("bid"+ bids);
        return bidsRepository.save(bids);
    }

    @PutMapping("/bid/{id}")
    public ResponseEntity <Bids> updateBid(@PathVariable(value = "id") Long bidId,
                                                @Valid @RequestBody Bids bidsDetails) throws ResourceNotFoundException {
        Bids bids = bidsRepository.findById(bidId)
                .orElseThrow(() -> new ResourceNotFoundException("Bids not found for this id :: " + bidId));

        bids.setOffer(bidsDetails.getOffer());
        final Bids updatedBids = bidsRepository.save(bids);
        return ResponseEntity.ok(updatedBids);
    }

    @DeleteMapping("/bid/{id}")
    public Map < String, Boolean > deleteBid(@PathVariable(value = "id") Long bidId)
            throws ResourceNotFoundException {
        Bids bids = bidsRepository.findById(bidId)
                .orElseThrow(() -> new ResourceNotFoundException("Bids not found for this id :: " + bidId));

        bidsRepository.delete(bids);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
