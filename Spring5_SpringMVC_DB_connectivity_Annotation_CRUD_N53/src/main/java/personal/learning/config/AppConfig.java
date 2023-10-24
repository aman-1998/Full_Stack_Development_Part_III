package personal.learning.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oracle.jdbc.pool.OracleDataSource;
import personal.learning.DAO.AppDAOImpl;

@Configuration
public class AppConfig {
	
	@Bean
	public DataSource getDataSource() {
		OracleDataSource dataSource = null;
		try {
			dataSource = new OracleDataSource();
			dataSource.setDataSourceName("ds");
			dataSource.setURL("jdbc:oracle:thin:@localhost:1521:XE");
			dataSource.setUser("SYSTEM");
			dataSource.setPassword("ORACLE");
		} catch (SQLException e) {
			System.out.println("Failed to populate datasource");
			e.printStackTrace();
		}
		return dataSource;
	}
	
	@Bean(name="DAOBean")
	public AppDAOImpl getAppDaoImpl() {
		return new AppDAOImpl(getDataSource());
	}
}
