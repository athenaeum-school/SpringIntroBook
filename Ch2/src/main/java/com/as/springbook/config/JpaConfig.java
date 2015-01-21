/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.jolbox.bonecp.BoneCPDataSource;

/**
 * @author komatsu
 *
 */
@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:application.properties" })
@ComponentScan(basePackages = {
		"com.as.springbook.service",
		"com.as.springbook.dto",
		//"com.as.springbook.domain",
		"com.as.springbook.service.impl", 
		"com.as.springbook.repository", 
		"com.as.springbook.annotation", 
		"com.as.springbook.auditor",
		"com.as.springbook.aspect"
}) 
@EnableAspectJAutoProxy
@ImportResource("classpath:jpa-app-context.xml")
public class JpaConfig {

    @Resource
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();

        dataSource.setDriverClass(environment.getRequiredProperty("jdbc.driver"));
        dataSource.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.user"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.pass"));

        return dataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager() throws ClassNotFoundException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());

        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws ClassNotFoundException {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(environment.getRequiredProperty("packages.scan"));
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        
        Properties jpaProterties = new Properties();
        jpaProterties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        jpaProterties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        jpaProterties.put("hibernate.ejb.naming_strategy", environment.getRequiredProperty("hibernate.ejb.naming_strategy"));
        jpaProterties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        jpaProterties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        
        entityManagerFactoryBean.setJpaProperties(jpaProterties);

        return entityManagerFactoryBean;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename(environment.getRequiredProperty("message_source_basename"));
        messageSource.setUseCodeAsDefaultMessage(Boolean.parseBoolean(environment.getRequiredProperty("message_source_use_code")));

        return messageSource;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
}

