package ua.gov.prozorro.service.updater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ClassifierUpdateService {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ClassifierUpdateService.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8003"));
        app.run(args);
    }
}
