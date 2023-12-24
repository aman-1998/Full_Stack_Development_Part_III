package personal.learning.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class DBConfiguration {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		OracleDataSource dataSource = null;
		try {
			dataSource = new OracleDataSource();
			//dataSource.setDataSourceName("ds");
			dataSource.setURL(env.getProperty("db.url"));
			dataSource.setUser(env.getProperty("db.username"));
			dataSource.setPassword(env.getProperty("db.password"));
		} catch(SQLException ex) {
			System.out.print("Failed to populate dataSource");
			ex.printStackTrace();
		}
		return dataSource;
	}
	
	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		//hibernateProperties.setProperty(org.hibernate.cfg.Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
		//hibernateProperties.setProperty(org.hibernate.cfg.Environment.URL, env.getProperty("db.url"));
		//hibernateProperties.setProperty(org.hibernate.cfg.Environment.USER, env.getProperty("db.user"));
		//hibernateProperties.setProperty(org.hibernate.cfg.Environment.PASS, env.getProperty("db.password"));
		hibernateProperties.setProperty(org.hibernate.cfg.Environment.HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty(org.hibernate.cfg.Environment.DIALECT, env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	    //hibernateProperties.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		hibernateProperties.setProperty(org.hibernate.cfg.Environment.CURRENT_SESSION_CONTEXT_CLASS, env.getProperty("hibernate.current_session_context_class"));
		
		//hibernateProperties.setProperty(org.hibernate.cfg.Environment.CONNECTION_PROVIDER, "org.hibernate.c3p0.internal.C3P0ConnectionProvider");
		//hibernateProperties.setProperty(org.hibernate.cfg.Environment.C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
		//hibernateProperties.setProperty(org.hibernate.cfg.Environment.C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
		//hibernateProperties.setProperty(org.hibernate.cfg.Environment.C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
		//hibernateProperties.setProperty(org.hibernate.cfg.Environment.C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
		//hibernateProperties.setProperty(org.hibernate.cfg.Environment.C3P0_IDLE_TEST_PERIOD, env.getProperty("hibernate.c3p0.idle_test_period"));
		//hibernateProperties.setProperty(org.hibernate.cfg.Environment.C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
		return hibernateProperties;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));
		//sessionFactoryBean.setAnnotatedClasses(Role.class, Users.class, School.class, Country.class, Language.class);
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		return sessionFactoryBean;
	}
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
		return hibernateTransactionManager;
	}
	
}
