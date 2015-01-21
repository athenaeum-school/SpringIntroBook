/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.jolbox.bonecp.BoneCPDataSource;

/**
 * @author komatsu
 *
 */
@Configuration
@PropertySource({ "classpath:application.properties" })
@ComponentScan(basePackages = {
		"com.as.springbook.service",
		"com.as.springbook.dto",
		"com.as.springbook.service.impl", 
		"com.as.springbook.repository", 
		"com.as.springbook.annotation", 
		"com.as.springbook.auditor",
		"com.as.springbook.aspect"
}) 
@EnableAspectJAutoProxy
@ImportResource("classpath:jpa-app-context.xml")
@Profile("test")
public class AbstractTestContextConfig {

    @Autowired
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
	
	@Bean(name="dbunitTester")
	public DataSourceDatabaseTester dataSourceDatabaseTester() {
		DataSourceDatabaseTester databaseTester = new DataSourceDatabaseTester(dataSource());
		return databaseTester;
	}
	
	@Bean(name="xlsDataFileLoader")
	public XlsDataFileLoader xlsDataFileLoader() {
		return new XlsDataFileLoader();
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

        entityManagerFactoryBean.setJpaProperties(jpaProterties);

        return entityManagerFactoryBean;
    }
	
}
