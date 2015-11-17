package org.smurve.hsr2014.inheritance;

import configuration.SpringJpaConfiguration;
import net.sf.ehcache.config.CacheConfiguration;
import org.smurve.hsr2014.utils.db.DatabaseConnector;
import org.smurve.hsr2014.utils.db.hsql.HSqlConnector;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import(SpringJpaConfiguration.class)
@EnableAspectJAutoProxy
@EnableJpaRepositories(basePackages = {"org.smurve.hsr2014.repo"})
@ComponentScan(basePackages = {
        "org.smurve.hsr2014.repo"})
public class DatabaseTestContextWithoutCaching {

    @Bean
    public DatabaseConnector databaseConnector() {
        return new HSqlConnector(); //MySqlConnector();
    }

}
