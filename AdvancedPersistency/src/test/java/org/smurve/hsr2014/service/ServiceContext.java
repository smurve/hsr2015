package org.smurve.hsr2014.service;

import org.smurve.hsr2014.inheritance.DatabaseTestContextWithoutCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(DatabaseTestContextWithoutCaching.class)
public class ServiceContext {

    @Bean
    public JpaBookService bookService () {
        return new JpaBookService();
    }
}
