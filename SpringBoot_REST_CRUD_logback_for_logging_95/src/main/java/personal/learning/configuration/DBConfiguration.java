package personal.learning.configuration;

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
import personal.learning.model.dao.BrandDAO;
import personal.learning.model.dao.ProductDAO;
import personal.learning.services.BrandService;
import personal.learning.services.ProductService;

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
			dataSource.setURL(env.getProperty("db.url"));
			dataSource.setUser(env.getProperty("db.username"));
			dataSource.setPassword(env.getProperty("db.password"));
		} catch (SQLException e) {
			System.out.println("Failed to populate datasource");
			e.printStackTrace();
		}
		return dataSource;
	}
    
    @Bean(name="brandRepo")
	public BrandDAO getBrandDAO() {
		return new BrandDAO();
	}
    
    @Bean(name="productRepo")
   	public ProductDAO getProductDAO() {
   		return new ProductDAO();
   	}
    
    @Bean(name="bService")
	public BrandService getBrandService() {
		return new BrandService();
	}
    
    @Bean(name="pService")
   	public ProductService getProductService() {
   		return new ProductService();
   	}
	
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	    transactionManager.setSessionFactory(sessionFactory().getObject());
	    return transactionManager;
	}

	private final Properties hibernateProperties() {
	    Properties hibernateProperties = new Properties();
	    hibernateProperties.setProperty(org.hibernate.cfg.Environment.HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
	    hibernateProperties.setProperty(org.hibernate.cfg.Environment.DIALECT, env.getProperty("hibernate.dialect"));
	    //hibernateProperties.setProperty(org.hibernate.cfg.Environment.SHOW_SQL, env.getProperty("hibernate.show_sql"));
	    //hibernateProperties.setProperty(org.hibernate.cfg.Environment.FORMAT_SQL, env.getProperty("hibernate.format_sql"));
	    hibernateProperties.setProperty(org.hibernate.cfg.Environment.CURRENT_SESSION_CONTEXT_CLASS, env.getProperty("hibernate.current_session_context_class"));
	    return hibernateProperties;
	}

/*
 * Below is the old school way of creating Hibernate SessionFactory Bean
 */
//	    @Bean(name="sessionFactory")
//	    public SessionFactory getSessionFactory() {
//	    	 
//	    	SessionFactory sessionFactory = null;
//	    	Map<String, String> dbSettings = new HashMap<String, String>();
//	    	dbSettings.put("hibernate.connection.driver_class", "oracle.jdbc.OracleDriver");
//	    	dbSettings.put("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:XE");
//	    	dbSettings.put("hibernate.connection.username", "SYSTEM");
//	    	dbSettings.put("hibernate.connection.password", "SYSTEM");
//	    	dbSettings.put("hibernate.dialect", "org.hibernate.dialect.Oracle8iDialect");
//	    	dbSettings.put("hibernate.show_sql", "true");
//	    	dbSettings.put("hibernate.format_sql", "true");
//	    	dbSettings.put("hibernate.hbm2ddl.auto", "none");
//	    	dbSettings.put("hibernate.current_session_context_class", "thread");
//	    	
//	    	try {
//	    		  ServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().applySettings(dbSettings).build();
//
//	    		  Metadata metadata = new MetadataSources(standardRegistry).addAnnotatedClass(Brand.class)
//																		   .addAnnotatedClass(Product.class)
//	    				  												   .getMetadataBuilder()
//	    				  												   .build();
//
//	    		  sessionFactory = metadata.getSessionFactoryBuilder().build();
//	    		  
//	    		} catch (Throwable ex) {
//	    		  throw new ExceptionInInitializerError(ex);
//	    		}
//	    	return sessionFactory;
//	    }
	    
}
