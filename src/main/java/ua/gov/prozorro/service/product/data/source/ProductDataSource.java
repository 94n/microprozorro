package ua.gov.prozorro.service.product.data.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.gov.prozorro.service.product.data.entity.Product;

import java.util.List;

@Component
public class ProductDataSource {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDataSource(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product find(String id) {
        if (id == null) return null;
        List<Product> products = jdbcTemplate.query(
                "SELECT name FROM PRODUCT WHERE id = ?",
                new Object[]{id},
                (rs, rowNum) -> new Product(id, rs.getString("name")));
        return products.isEmpty() ? null : products.get(0);
    }

}
