import java.lang.*;
import java.util.List;

public interface CustomerDAO {
	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
  public Customer getCustomerById(int customer_id);
  public List<Customer> findAll();
  public List<Customer> getCustomerByName();
}