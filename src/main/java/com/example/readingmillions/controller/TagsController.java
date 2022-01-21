package com.example.readingmillions.controller;

import com.example.readingmillions.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagsController {

    @Autowired
    TagsService tagsService;

    @RequestMapping("/get/tags")
    public ResponseEntity<Object> getTags() {
        tagsService.getData();
        return ResponseEntity.ok().body("success");
    }
}
