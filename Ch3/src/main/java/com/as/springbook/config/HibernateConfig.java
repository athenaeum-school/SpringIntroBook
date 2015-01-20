package com.as.springbook.config;

import java.lang.annotation.Annotation;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.Interceptor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.ejb.event.EntityCallbackHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;

import com.as.springbook.aspect.SystemSecurityAdvice;
import com.as.springbook.domain.SecurityFilter;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:application.properties" })
@ComponentScan(basePackages = {
		"com.as.springbook.service.impl", 
		"com.as.springbook.repository.impl", 
		"com.as.springbook.annotation", 
		"com.as.springbook.auditor",
		"com.as.springbook.aspect"
}) 
@EnableAspectJAutoProxy
@ImportResource("classpath:web-app-context.xml")
public class HibernateConfig {

    @Autowired
    private Environment env;

    public HibernateConfig() {
        super();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean(){
			protected Configuration newConfiguration() {
				return new Configuration() {
					public Configuration setInterceptor(Interceptor interceptor) {
						throw new IllegalArgumentException(interceptor.toString());
					}

					@Override
					public Class<? extends Annotation> annotationType() {
						// not implemented
						return null;
					}

					@Override
					public String value() {
						// not implemented
						return null;
					}
				};
			}
		};
        sessionFactory.setDataSource(restDataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.as.springbook.domain" });
        sessionFactory.setHibernateProperties(hibernateProperties());
     
        return sessionFactory;
    }

    @Bean
    public DataSource restDataSource() {
        final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));

        return dataSource;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(final SessionFactory sessionFactory) {
        final HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator(){
    	return new HibernateExceptionTranslator();
    }

    final Properties hibernateProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.ejb.event.post-insert", "org.hibernate.ejb.event.EJB3PostInsertEventListener,org.hibernate.envers.event.AuditEventListener");
        hibernateProperties.setProperty("hibernate.ejb.event.post-update", "org.hibernate.ejb.event.EJB3PostUpdateEventListener,org.hibernate.envers.event.AuditEventListener");
        hibernateProperties.setProperty("hibernate.ejb.event.post-delete", "org.hibernate.ejb.event.EJB3PostDeleteEventListener,org.hibernate.envers.event.AuditEventListener");
        hibernateProperties.setProperty("hibernate.ejb.event.pre-collection-update", "org.hibernate.envers.event.AuditEventListener");
        hibernateProperties.setProperty("hibernate.ejb.event.post-collection-recreate", "org.hibernate.envers.event.AuditEventListener");
        hibernateProperties.setProperty("org.hibernate.envers.audit_table_suffix", "_REV");        
        hibernateProperties.setProperty("org.hibernate.envers.revision_field_name", "AUDIT_REVISION");        
        hibernateProperties.setProperty("org.hibernate.envers.revision_type_field_name", "ACTION_TYPE");
        hibernateProperties.setProperty("org.hibernate.envers.audit_strategy", "org.hibernate.envers.strategy.ValidityAuditStrategy");        
        hibernateProperties.setProperty("org.hibernate.envers.audit_strategy_validity_end_rev_field_name", "AUDIT_REV_END");        
        hibernateProperties.setProperty("org.hibernate.envers.audit_strategy_validity_store_revend_timestamp", "true");        
        hibernateProperties.setProperty("org.hibernate.envers.audit_strategy_validity_revend_timestamp_field_name", "AUDIT_REV_END_TIMESTAMP");
        
        return hibernateProperties;
    }
    
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename(env.getRequiredProperty("message_source_basename"));
        messageSource.setUseCodeAsDefaultMessage(Boolean.parseBoolean(env.getRequiredProperty("message_source_use_code")));

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
    
    @Bean
    public SecurityFilter securityFilter() {
    	SecurityFilter securityFilter = new SecurityFilter();

    	return securityFilter;
    }
    
    @Bean
    public SystemSecurityAdvice systemSecurityAdvice() {
        return new SystemSecurityAdvice();
    }

}