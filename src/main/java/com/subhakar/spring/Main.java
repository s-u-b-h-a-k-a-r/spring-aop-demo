package com.subhakar.spring;

import com.github.javafaker.Faker;
import com.subhakar.spring.factory.CartFactory;
import com.subhakar.spring.product.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        CartFactory cartFactory = context.getBean(CartFactory.class);

        Faker faker = new Faker();
        cartFactory.addProduct(Product.builder()
                .id(faker.beer().name())
                .name(faker.beer().style())
                .description(faker.beer().style())
                .build());

        faker = new Faker();
        cartFactory.addProduct(Product.builder()
                .id(faker.beer().name())
                .name(faker.beer().style())
                .description(faker.beer().style())
                .build());
        cartFactory.printProducts();
    }
}
