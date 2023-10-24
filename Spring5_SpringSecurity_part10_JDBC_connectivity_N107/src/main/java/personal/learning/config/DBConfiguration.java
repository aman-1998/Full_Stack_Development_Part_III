package personal.learning.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import oracle.jdbc.pool.OracleDataSource;
import personal.learning.dao.AppDao;

@Configuration
@PropertySource("classpath:database.properties")
public class DBConfiguration {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		OracleDataSource dataSource = null;
		try {
			dataSource = new OracleDataSource();
			dataSource.setDataSourceName("ds");
			dataSource.setURL(env.getProperty("db.url"));
			dataSource.setUser(env.getProperty("db.username"));
			dataSource.setPassword(env.getProperty("db.password"));
		} catch(SQLException ex) {
			System.out.print("Failed to populate dataSource");
			ex.printStackTrace();
		}
		return dataSource;
	}
	
	@Bean(name="daoBean")
	public AppDao getAppDao() {
		return new AppDao(dataSource());
	}
}
