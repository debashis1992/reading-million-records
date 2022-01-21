package com.example.readingmillions.service;

import com.example.readingmillions.entity.GenomeEntity;
import com.example.readingmillions.entity.TagsEntity;
import com.example.readingmillions.repository.GenomeRepository;
import com.example.readingmillions.repository.TagsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
public class GenomeService {
    @Autowired
    GenomeRepository genomeRepository;

    @Autowired
    EntityManager entityManager;

    @Transactional(readOnly = true)
    public void getData() {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Stream<GenomeEntity> tagsEntityStream = genomeRepository.getAll();
        List<GenomeEntity> list = new ArrayList<>();
        tagsEntityStream.forEach(tagsEntity -> {
            list.add(tagsEntity);
            entityManager.detach(tagsEntity);
        });

        stopWatch.stop();
        log.info("Total time taken: {}", stopWatch.getLastTaskTimeMillis());
    }
}
