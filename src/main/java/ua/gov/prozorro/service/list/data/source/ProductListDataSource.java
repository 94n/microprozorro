package ua.gov.prozorro.service.list.data.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.gov.prozorro.service.list.data.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductListDataSource {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductListDataSource(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findSubList(String code) {
        if (code == null) return null;
        String id = code.length() > 5 ? code.substring(0, 5) : code;
        String codePart = id.contains("-") ? id.substring(0, id.indexOf("-")).replaceAll("0+$", "") : id.replaceAll("0+$", "");
        return jdbcTemplate.query(
                "SELECT * FROM product WHERE id LIKE ? ORDER BY id",
                new Object[]{codePart + "%"},
                (rs, rowNum) -> new Product(rs.getString("id"), rs.getString("name"))).
                stream().filter(p -> !id.equals(p.getId())).collect(Collectors.toList());
    }

}
