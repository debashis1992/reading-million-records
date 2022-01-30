package com.example.readingmillions.service;

import com.example.readingmillions.entity.ParkingEntity;
import com.example.readingmillions.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    @Transactional
    public void insert() {
        long start = System.currentTimeMillis();
        long end = start+5000;

        while(start < end) {
            ParkingEntity entity = new ParkingEntity();
            entity.setUserId(1);
            entity.setMovieId(1000);

            parkingRepository.save(entity);
        }
    }
}
