package com.friendkeeper.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.friendkeeper")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public DataSource myDataSource() {
		ComboPooledDataSource source = new ComboPooledDataSource();
		try {
			source.setDriverClass(env.getProperty("jdbc.driver"));
		}
		catch(PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		logger.info("jdbc.url="+ env.getProperty("jdbc.url"));
		logger.info("jdbc.user="+ env.getProperty("jdbc.user"));
		
		source.setJdbcUrl(env.getProperty("jdbc.url"));
		source.setUser(env.getProperty("jdbc.user"));
		source.setPassword(env.getProperty("jdbc.password"));
		
		source.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		source.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		source.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		source.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return source;	
	}
	
	//helper method for setting jdbc pool sizes
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName); 
		return Integer.parseInt(propVal);
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}
	
	//helper method for making our session factory
	private Properties getHibernateProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return props;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(sessionFactory);
		return manager;
	}
}
