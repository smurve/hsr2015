package org.smurve.hsr2014.apis;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultRecordMapper;
import org.smurve.hsr2014.service.JooqBookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Configuration for Spring-Jooq integration
 * The trick here is to provide Jooq with the transaction-aware DataSource proxy
 */
@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
public class TestContext {

    @Bean(name="dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(com.mysql.jdbc.Driver.class.getCanonicalName());
        dataSource.setUrl("jdbc:mysql://localhost:3306");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        try {
            dataSource.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }

    @Bean(name = "txDs")
    public DataSource txAwareDs (DataSource dataSource) {
        return new TransactionAwareDataSourceProxy ( dataSource );
    }

    @Bean
    public DSLContext configuration ( @Qualifier("txDs") DataSource dataSource ) {
        return DSL.using(new DefaultConfiguration()
                .set(dataSource)
                .set(SQLDialect.MYSQL)
                .set(new RecordMapperProvider() {
                    @Override
                    public <R extends Record, E> RecordMapper<R, E> provide(RecordType<R> recordType, Class<? extends E> type) {
                        return new DefaultRecordMapper<>(recordType, type);
                    }
                }));
    }

    @Bean
    public PlatformTransactionManager transactionManager ( @Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public JooqBookService bookService () {
        return new JooqBookService();
    }
}
