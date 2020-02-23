package ua.gov.prozorro.service.updater.data.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.gov.prozorro.service.list.data.entity.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ClassifierUpdateDataSource {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClassifierUpdateDataSource(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> updateCreate(Map<String, String> products) {
        for (String id : products.keySet()) {
            String name = products.get(id);
            jdbcTemplate.update(
                    "INSERT INTO product (id, name) VALUES (?, ?) ON CONFLICT DO NOTHING",
                    id, name
            );
        }
        return jdbcTemplate.query(
                "SELECT * FROM product ORDER BY id",
                (rs, rowNum) -> new Product(rs.getString("id"), rs.getString("name")));
    }

}
