package com.userservice.externalservices;

import com.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(Rating values);

    @PutMapping("/ratings")
    public ResponseEntity<Rating> updateRating(@RequestParam("ratingId") String ratingId, Rating rating);

    @DeleteMapping("/ratings")
    public void deleteRating(@RequestParam String ratingId);

}
