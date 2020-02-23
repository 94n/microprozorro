package ua.gov.prozorro.service;

import ua.gov.prozorro.service.list.ProductListService;
import ua.gov.prozorro.service.product.ProductService;
import ua.gov.prozorro.service.updater.ClassifierUpdateService;

public class MainRunner {

    public static void main(String[] args) {
        ProductService.main(args);
        ProductListService.main(args);
        ClassifierUpdateService.main(args);
    }

}
