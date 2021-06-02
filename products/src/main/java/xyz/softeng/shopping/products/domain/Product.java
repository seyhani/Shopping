package xyz.softeng.shopping.products.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.softeng.shopping.products.application.ProductEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@EntityListeners(ProductEntityListener.class)
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer price;

    private String vendorUsername;

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
