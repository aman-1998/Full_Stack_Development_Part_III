package personal.learning.DAO;

import java.util.List;
import java.util.Map;

import personal.learning.model.Customer;

public interface AppDAO {
	List<Customer> listCustomers();
	void saveCustomer(Customer customer);
	boolean isNewCustomer(String email);
	void removeCustomer(String email);
	Map<String,String> getCountryListfromDB();
}
