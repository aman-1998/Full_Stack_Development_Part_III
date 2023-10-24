package personal.learning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class AppDao {
	
	private DataSource dataSource;
	
	public AppDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Optional<String> getSchoolName() {
		Connection conn = null;
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * ");
		sb.append("FROM ");
		sb.append("SCHOOL");
		String query = sb.toString();
		String school = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				school = rs.getString("name");
			}
		} catch (SQLException e) {
			System.out.println("Exception : " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Optional.ofNullable(school);
	}
}
