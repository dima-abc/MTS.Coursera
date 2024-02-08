package mts.coursera.MTS.Coursera;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CourseApp {

    public static void main(String[] args) {
        SpringApplication.run(CourseApp.class, args);
        log.info("Go TO page: http://localhos:8080");
    }
}
