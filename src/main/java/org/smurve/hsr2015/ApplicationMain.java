package org.smurve.hsr2015;

import org.smurve.hsr2015.books.BookRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan(basePackageClasses = ApplicationMain.class)
@EnableJpaRepositories(basePackageClasses = BookRepo.class)
public class ApplicationMain {

    public static void main(String[] args) {

        SpringApplication.run(ApplicationMain.class);
    }

}
