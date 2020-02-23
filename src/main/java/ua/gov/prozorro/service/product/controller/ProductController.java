package ua.gov.prozorro.service.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.gov.prozorro.service.product.data.entity.Product;
import ua.gov.prozorro.service.product.data.source.ProductDataSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    private final ProductDataSource dataSource;

    @Autowired
    public ProductController(ProductDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/product/{id}")
    //@PreAuthorize("isAuthenticated()")
    public List<Product> find(@PathVariable String id) {
        return Collections.singletonList((dataSource.find(id)));
    }

}
