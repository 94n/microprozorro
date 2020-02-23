package ua.gov.prozorro.service.list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ProductListService {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ProductListService.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8002"));
        app.run(args);
    }

}
