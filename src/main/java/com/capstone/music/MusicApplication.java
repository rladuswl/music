package com.capstone.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MusicApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml,"
            + "classpath:aws.yml";

    public static void main(String[] args) {

        // SpringApplication.run(MusicApplication.class, args);

        new SpringApplicationBuilder(MusicApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }

}
