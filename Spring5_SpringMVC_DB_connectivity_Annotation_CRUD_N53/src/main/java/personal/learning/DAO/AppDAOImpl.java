package personal.learning.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sql.DataSource;
import javax.validation.Valid;

import personal.learning.model.Customer;
import personal.learning.utility.Utility;

public class AppDAOImpl implements AppDAO {
	
	private DataSource dataSource;
	
	public AppDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void saveCustomer(Customer customer) {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			int recordsCount = customer.getLanguage().length;
			for(int i = 0; i <= recordsCount-1; i++) {
				StringBuffer sb1 = new StringBuffer();
				sb1.append("insert into customer ");
				sb1.append("(customer_pk, ");
				sb1.append("email, ");
				sb1.append("name, ");
				sb1.append("gender, ");
				sb1.append("language, ");
				sb1.append("dob, ");
				sb1.append("country_id, ");
				sb1.append("address) ");
				sb1.append("values (customer_sequence.nextval, ?, ?, ?, ?, ?, ?, ?)");
				String query = sb1.toString();
				
				ps = conn.prepareStatement(query);
				ps.setString(1, customer.getEmail());
				ps.setString(2, customer.getName());
				ps.setString(3, customer.getGender());
				ps.setString(4, customer.getLanguage()[i]);
				ps.setDate(5, new java.sql.Date(customer.getDateOfBirth().getTime()));
				ps.setInt(6, Integer.valueOf(customer.getCountry()));
				ps.setString(7, customer.getAddress());
				ps.execute();
			}
			
		} catch (SQLException e) {
			System.out.println("Exception : " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				System.out.println("Failed to close database connection : " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Customer> listCustomers() {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		StringBuffer sb = new StringBuffer();
		sb.append("select email, name, gender, language, dob, country_pk, country, address ");
		sb.append("from ");
		sb.append("customer   cus, ");
		sb.append("country    con ");
		sb.append("where ");
		sb.append("cus.country_id = con.country_pk ");
		String query = sb.toString();
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			LinkedList<String> emailList = new LinkedList<String>();
			LinkedList<String> nameList = new LinkedList<String>();
			LinkedList<String> genderList = new LinkedList<String>();
			LinkedList<String> langList = new LinkedList<String>();
			LinkedList<String> dobList = new LinkedList<String>();
			LinkedList<String> countryList = new LinkedList<String>();
			LinkedList<String> countryNameList = new LinkedList<String>();
			LinkedList<String> addressList = new LinkedList<String>();
			while(rs.next()) {
				emailList.add(rs.getString("email"));
				nameList.add(rs.getString("name"));
				genderList.add(rs.getString("gender"));
				langList.add(rs.getString("language"));
				dobList.add(rs.getString("dob"));
				countryList.add(rs.getString("country_pk"));
				countryNameList.add(rs.getString("country"));
				addressList.add(rs.getString("address"));
			}
			
			HashSet<String> uniqueEmailsSet = new HashSet<String>(emailList);
			
			for(String email1 : uniqueEmailsSet) {
				String cusEmail = null;
				String cusName = null;
				String cusGender = null;
				String cusDob = null;
				String cusCountry = null;
				String cusCountryName = null;
				String[] cusLang = new String[4];
				String cusAddress = null;
				int index = 0;
				int langIndex = 0;
				for(String email2 : emailList) {
					if(email1.equals(email2)) {
						cusEmail = emailList.get(index); // email2
						cusName = nameList.get(index);
						cusGender = genderList.get(index);
						cusDob = dobList.get(index);
						cusCountry = countryList.get(index);
						cusCountryName = countryNameList.get(index);
						cusLang[langIndex] = langList.get(index);
						if(addressList.get(index) != null) {
							if(!addressList.get(index).isEmpty()) {
								cusAddress = addressList.get(index);
							}
						}
						langIndex++;
					}
					index++;
				}
				Date cusDateOfBirth = Utility.convertDateToDisplayFormat(cusDob);
				customerList.add(new Customer(cusEmail, cusName, cusGender, cusDateOfBirth, cusDob, cusCountry, cusCountryName, cusLang, cusAddress));
			}
		} catch (SQLException e) {
			System.out.println("Exception : " + e.getMessage());
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("Failed to close database connection : " + e.getMessage());
					e.printStackTrace();
				}
			}
		}
		
		return customerList;
	}
	
	@Override
	public boolean isNewCustomer(String email) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			LinkedList<String> emailList = new LinkedList<String>();
			StringBuffer sb1 = new StringBuffer();
			sb1.append("select email from customer");
			String query = sb1.toString();
			ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emailList.add(rs.getString("email"));
			}
			// Checks duplicate customer
			if(emailList.contains(email)) {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Exception : " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				System.out.println("Failed to close database connection : " + e.getMessage());
				e.printStackTrace();
			}
		}
		return true;
	}
	
	@Override
	public void removeCustomer(String email) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("delete from customer where email = '"+email+"'");
			String query = sb.toString();
			ps = conn.prepareStatement(query);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Exception : " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				System.out.println("Failed to close database connection : " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Map<String,String> getCountryListfromDB() {
		Map<String,String> countryMap = new TreeMap<String,String>();
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			StringBuffer sb1 = new StringBuffer();
			sb1.append("select * from country");
			String query = sb1.toString();
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<String> countryKeyList = new ArrayList<String>();
			ArrayList<String> countryValueList = new ArrayList<String>();
			while(rs.next()) {
				countryKeyList.add(rs.getString("country_pk"));
				countryValueList.add(rs.getString("country"));
			}
			
			for(int i = 0; i <= countryKeyList.size()-1; i++) {
				countryMap.put(countryKeyList.get(i), countryValueList.get(i));
			}
			
		} catch (SQLException e) {
			System.out.println("Exception : " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				System.out.println("Failed to close database connection : " + e.getMessage());
				e.printStackTrace();
			}
		}
		
		return countryMap;
	}

}
