package ua.gov.prozorro.service.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ProductService {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ProductService.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8001"));
        app.run(args);
    }
}
