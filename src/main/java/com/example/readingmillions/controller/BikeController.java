package com.example.readingmillions.controller;

import com.example.readingmillions.service.BikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BikeController {

    @Autowired
    BikerService bikerService;

    @RequestMapping("/get/bikes")
    public ResponseEntity<Object> getBikes() {
        bikerService.getData();
        return ResponseEntity.ok().body("success");
    }
}
