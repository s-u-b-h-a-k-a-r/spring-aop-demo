package com.subhakar.spring.factory;

import com.subhakar.spring.exception.ProductNotFoundException;
import com.subhakar.spring.product.Product;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CartFactory {
    private Set<Product> products = new HashSet<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public Set<Product> listProducts() {
        return products;
    }

    public Product getProduct(String id) {
        Product _product = products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id :" + id));
        return _product;
    }

    public void printProducts() {
        products.parallelStream().forEach(System.out::println);
    }
}
