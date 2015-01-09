/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.as.springbook.domain.AddressImpl;
import com.as.springbook.domain.BookImpl;
import com.as.springbook.domain.ClientImpl;
import com.as.springbook.domain.InventoryImpl;
import com.as.springbook.domain.LibraryImpl;
import com.as.springbook.domain.RentalImpl;
import com.as.springbook.domain.StaffImpl;

/**
 * @author komatsu
 * This Dao configuration pattern serves for the domain
 * layer tests.
 * 
 */

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:mysql.properties" })
public class HibernateDaoConfig {

    @Autowired
    private Environment env;
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		Properties props = new Properties();
		props.put("hibernate.dialect", MySQL5Dialect.class.getName());
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "create");

		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setAnnotatedClasses(new Class[]{BookImpl.class, InventoryImpl.class,
				AddressImpl.class, ClientImpl.class, StaffImpl.class,
				RentalImpl.class, LibraryImpl.class});		
		bean.setHibernateProperties(props);
		bean.setDataSource(restDataSource());
		return bean;
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
	public HibernateTransactionManager transactionManager() {
		return new HibernateTransactionManager( sessionFactoryBean().getObject() );
	}

}
