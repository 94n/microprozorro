package ua.gov.prozorro.service.updater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ua.gov.prozorro.service.list.data.entity.Product;
import ua.gov.prozorro.service.updater.data.source.ClassifierUpdateDataSource;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ClassifierUpdateController {

    private final ClassifierUpdateDataSource dataSource;

    @Autowired
    public ClassifierUpdateController(ClassifierUpdateDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/update")
    //@PreAuthorize("isAuthenticated()")
    public List<Product> update() {
        ResponseEntity<Map> responseEntity =
                new RestTemplate().getForEntity("https://prozorroukr.github.io/standards/classifiers/dk021_uk.json", Map.class);
        Map<String, String> classifier = responseEntity.getBody();
        return dataSource.updateCreate(classifier);
    }

}
