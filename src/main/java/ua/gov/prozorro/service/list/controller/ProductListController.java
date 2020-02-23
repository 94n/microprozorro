package ua.gov.prozorro.service.list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.gov.prozorro.service.list.data.entity.Product;
import ua.gov.prozorro.service.list.data.source.ProductListDataSource;

import java.util.List;

@RestController
public class ProductListController {

    private final ProductListDataSource dataSource;

    @Autowired
    public ProductListController(ProductListDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/productsublist/{id}")
    //@PreAuthorize("isAuthenticated()")
    public List<Product> findSubList(@PathVariable String id) {
        return dataSource.findSubList(id);
    }

}
