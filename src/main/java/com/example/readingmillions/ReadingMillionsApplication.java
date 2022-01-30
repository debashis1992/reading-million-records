package com.example.readingmillions;

import com.example.readingmillions.service.BikerService;
import com.example.readingmillions.service.FileService;
import com.example.readingmillions.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class ReadingMillionsApplication {

	@Autowired
	private FileService fileService;

	@Autowired
	private ParkingService parkingService;

	public static void main(String[] args) {
		SpringApplication.run(ReadingMillionsApplication.class, args);
	}

	@PostConstruct
	public void processFile() throws IOException {
//		fileService.processFile();
	}

	@PostConstruct
	public void insert() {
//		parkingService.insert();
	}
}
