package org.smurve.hsr2015.books;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
//@ComponentScan(basePackageClasses = BookController.class)
@EnableJpaRepositories(basePackageClasses = BookRepo.class)
public class TestContext {

    @Bean
    public BookController bookController () {
        return new BookController();
    }
}
