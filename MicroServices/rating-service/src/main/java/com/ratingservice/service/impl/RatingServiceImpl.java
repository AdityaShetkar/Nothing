package com.ratingservice.service.impl;

import com.ratingservice.entities.Rating;
import com.ratingservice.repository.RatingRepository;
import com.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository repository;

    @Override
    public Rating create(Rating rating) {
        return this.repository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return this.repository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return this.repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return this.repository.findByHotelId(hotelId);
    }

}
