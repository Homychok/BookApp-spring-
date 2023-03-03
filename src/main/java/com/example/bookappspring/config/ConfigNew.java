package com.example.bookappspring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;


@Configuration
@ComponentScan(basePackages = "com")
@EnableWebMvc
@EnableTransactionManagement
public class ConfigNew {
    @Bean
    public DataSource getDataSource () {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("org.postgresql.Driver");
            dataSource.setJdbcUrl("jdbc:postgresql://localhost/book-db");
            dataSource.setUser("postgres");
            dataSource.setPassword("22091996cfif");
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan("com.example.bookappspring.entity");

        Properties properties = new Properties();

        properties.setProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("show_sql", "true");

        sessionFactory.setHibernateProperties(properties);

        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {

        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();

        transactionManager.setSessionFactory(getSessionFactory().getObject());

        return transactionManager;

    }
}
