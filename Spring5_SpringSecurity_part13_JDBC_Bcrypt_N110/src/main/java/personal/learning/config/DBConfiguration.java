package personal.learning.config;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import oracle.jdbc.pool.OracleDataSource;
import personal.learning.dao.AppDao;

@Configuration
@PropertySource("classpath:database.properties")
public class DBConfiguration {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		
		ComboPooledDataSource cpDataSource = new ComboPooledDataSource();
		try {
			// set database properties
			
			cpDataSource.setDriverClass(env.getProperty("db.driver"));
			cpDataSource.setJdbcUrl(env.getProperty("db.url"));
			cpDataSource.setUser(env.getProperty("db.user"));
			cpDataSource.setPassword(env.getProperty("db.password"));
			
			// set connection pool properties
			cpDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
			cpDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
			cpDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
			cpDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
			
		} catch (PropertyVetoException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		
		return cpDataSource;
	}
	
	/**
	 * It is helper method to convert property value in string
	 * to property integer
	 * 
	 * @param propName: Name of property
	 * @return intPropValue: Value of property in integer
	 */
	private int getIntProperty(String propName) {
		
		String propVal = env.getProperty(propName);
		int intPropValue = Integer.valueOf(propVal);
		return intPropValue;
	}
	
}
