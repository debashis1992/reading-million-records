package com.example.readingmillions.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Service
@Slf4j
public class FileService {

    public long processFile(MultipartFile file) throws IOException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        InputStream inputStream = file.getInputStream();
        new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines().forEach(this::printLine);

        stopWatch.stop();
        return stopWatch.getLastTaskTimeMillis();
    }

    public void printLine(String line) {
        log.info(line);
    }

    public long processFileUsingFileChannel(MultipartFile file) throws IOException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        //convert a multipart file to file
        File f = convert(file);

        FileChannel inChannel = new FileInputStream(f).getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while(inChannel.read(buffer) > 0) {
//            String s = new String(buffer.array(), 0, buffer.position());
//            log.info(s);
            log.info("printing");
            buffer.clear();
        }

        inChannel.close();
        f.delete();
        stopWatch.stop();
        return stopWatch.getLastTaskTimeMillis();

        // NYC file of 2.15 gb, takes 14.361 seconds time
        // genome file of 24 mb, takes 0.15s (154ms) time
    }

    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        try(InputStream is = file.getInputStream()) {
            Files.copy(is, convFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        return convFile;
    }

    private void printLine(byte b) {
        log.info(String.valueOf(b));
    }


}
