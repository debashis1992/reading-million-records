package com.example.readingmillions.service;

import com.example.readingmillions.entity.BikerInfo;
import com.example.readingmillions.repository.BikersInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class BikerService {

    @Autowired
    private BikersInfoRepository bikersInfoRepository;

    @Autowired
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public void getData() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
//        List<BikerInfo> bikerInfos = bikersInfoRepository.findAll();

        Stream<BikerInfo> list = bikersInfoRepository.getAll();

        list.forEach(li -> {
            entityManager.detach(li);
        });
        stopWatch.stop();
        log.info("Total time taken: {}", stopWatch.getLastTaskTimeMillis());
    }

}
