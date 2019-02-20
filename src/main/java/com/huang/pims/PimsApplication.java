package com.huang.pims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.huang.pims.*"})
@EnableCaching
public class PimsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PimsApplication.class, args);
    }

}

