package poc.raviraj.cxfrspoc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
// @EnableTransactionManagement
@PropertySource({ "classpath:database.properties" })
public class DatabaseBeanConfiguration {

	@Autowired
	private Environment env;

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(env.getRequiredProperty("jdbc.user"));
		dataSource.setPassword(env.getRequiredProperty("jdbc.pass"));
		return dataSource;
	}

	@Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		/**
		 * properties.setProperty("hibernate.c3p0.min_size",
		 * env.getProperty("hibernate.c3p0.min_size"));
		 * properties.setProperty("hibernate.c3p0.max_size",
		 * env.getProperty("hibernate.c3p0.max_size"));
		 * properties.setProperty("hibernate.c3p0.timeout",
		 * env.getProperty("hibernate.c3p0.timeout"));
		 * properties.setProperty("hibernate.c3p0.max_statements",
		 * env.getProperty("hibernate.c3p0.max_statements"));
		 * properties.setProperty("hibernate.c3p0.idle_test_period",
		 * env.getProperty("hibernate.c3p0.idle_test_period"));
		 */

		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource, Properties hibernateProperties) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		// sessionFactory.setDataSource(dataSource());
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(new String[] { "poc.raviraj.cxfrspoc.model" });
		// sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.setHibernateProperties(hibernateProperties);

		return sessionFactory;

	}

	// @Autowired
	// @Bean(name = "transactionManager")
	// public HibernateTransactionManager getTransactionManager(SessionFactory
	// sessionFactory) {
	// HibernateTransactionManager transactionManager = new
	// HibernateTransactionManager();
	// transactionManager.setSessionFactory(sessionFactory);
	//
	// return transactionManager;
	// }

}
