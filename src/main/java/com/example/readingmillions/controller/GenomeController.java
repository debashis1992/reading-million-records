package com.example.readingmillions.controller;

import com.example.readingmillions.service.GenomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenomeController {

    @Autowired
    GenomeService genomeService;

    @RequestMapping("/get/genome")
    public ResponseEntity<Object> getData() {
        genomeService.getData();
        return ResponseEntity.ok().body("success");

    }
}
