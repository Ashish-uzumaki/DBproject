import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CustomerDAO_JDBC implements CustomerDAO {
	Connection dbConnection;

	public CustomerDAO_JDBC(Connection dbconn){
		dbConnection = dbconn;
	}
	static final Scanner scan = new Scanner(System.in);

	@Override
	public Customer getCustomerById(int customer_id) {

		Customer s = new Customer();
		String sql;
		Statement stmt = null;

		try{
			stmt = dbConnection.createStatement();
			sql = "SELECT * FROM Customer WHERE customer_id = (?)";
      stmt.setInt(1, customer_id);
			ResultSet rs = stmt.executeQuery(sql);
			String name = rs.getString("name");
      String contact = rs.getString("contact");
      String address = rs.getString("address");
      int customer_id  = rs.getInt("customer_id");
      s.setName(name);
			s.setContact(contact);
      s.setAddress(address);
      s.setCustomerID(customer_id);
		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return s;
	}

	@Override
	public void addCustomer(Customer Customer) {
		PreparedStatement preparedStatement = null;
		String sql;
		sql = "insert into Customer(customer_id, name, address, contact) values (?,?,?,?)";

		try {
			preparedStatement = dbConnection.prepareStatement(sql);

			preparedStatement.setInt(1, Customer.getcustomer_id());
			preparedStatement.setString(2, Customer.getName());
      preparedStatement.setString(3, Customer.getAddress());
      preparedStatement.setString(4, Customer.getContact());
			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Customer added to the database");
		} catch (SQLException e) {
 			System.out.println(e.getMessage());
 		}

		try{
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
 			System.out.println(e.getMessage());
 		}
	}

  @Override
	public void updateCustomer(int customer_id) {
    static final Scanner scan = new Scanner(System.in);
		PreparedStatement preparedStatement = null;
		String sql;
    try{
    System.out.print("New name: ");
    String newName = scan.nextLine();
    System.out.print("New contact: ");
    String newContact = scan.nextLine();
    System.out.print("New address: ");
    String newAddress = scan.nextLine();
    stmt = conn.prepareStatement("UPDATE Customer SET name=(?), contact=(?), address=(?) WHERE customer_id=(?)");
    stmt.setInt(4, id);
    stmt.setString(1, newName);
    stmt.setString(2, newContact);
    stmt.setString(3, newAddress);
		} catch (SQLException e) {
 			System.out.println(e.getMessage());
 		}
		try{
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
 			System.out.println(e.getMessage());
 		}
	}

  @Override
	public void deleteCustomer(int customer_id) {
    PreparedStatement stmt = null;
    try {
      stmt = conn.prepareStatement("DELETE FROM Customer WHERE id=(?)");
      stmt.setInt(1, customer_id);
      stmt.executeUpdate();
      System.out.println("Deleted row successfully.");
    } catch (SQLException e) {
 			System.out.println(e.getMessage());
 		}
		try{
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
 			System.out.println(e.getMessage());
 		}
	}
}
