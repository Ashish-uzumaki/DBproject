import java.lang.*;
import java.util.List;
import java.util.ArrayList;

public interface CustomerDAO {
	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
  public Customer getCustomerById(int customer_id);
  // public List<Customer> findAll();
  // public List<Customer> getCustomerByName();
	public ArrayList<Transaction> getTransactionDetails(int customer_id);
	public ArrayList<Loan> getLoanDetails(int customer_id);
	public ArrayList<Account> getAllAccounts(int customer_id);
}
