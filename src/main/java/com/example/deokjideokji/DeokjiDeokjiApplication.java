package com.example.deokjideokji;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.TimeZone;

@Slf4j
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DeokjiDeokjiApplication {

    public static void main(String[] args) {

        init();
        SpringApplication.run(DeokjiDeokjiApplication.class, args);
    }

    private static void init() {
        log.info("Server TimeZone : Asia/Seoul");
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }
}
