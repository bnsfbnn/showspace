package com.ntq.showspace.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.ntq", excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {
        Controller.class }))
@EnableTransactionManagement
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.ntq.showspace.entity");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver") != null ? env.getProperty("db.driver")
                : "org.postgresql.Driver");
        dataSource.setUrl(env.getProperty("db.url") != null ? env.getProperty("db.url")
                : "jdbc:postgresql://localhost:5432/showspace");
        dataSource.setUsername(
                env.getProperty("db.username") != null ? env.getProperty("db.username") : "postgres");
        dataSource.setPassword(
                env.getProperty("db.password") != null ? env.getProperty("db.password") : "postgres");
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect",
                env.getProperty("hibernate.dialect") != null ? env.getProperty("hibernate.dialect")
                        : "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.show_sql",
                env.getProperty("hibernate.show_sql") != null ? env.getProperty("hibernate.show_sql")
                        : true);
        properties.put("hibernate.format_sql",
                env.getProperty("hibernate.format_sql") != null
                        ? env.getProperty("hibernate.format_sql")
                        : true);
        properties.put("hibernate.ddl-auto",
                env.getProperty("hibernate.ddl-auto") != null ? env.getProperty("hibernate.ddl-auto")
                        : "update");
        return properties;
    }
}
