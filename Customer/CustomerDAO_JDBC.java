import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.*;

public class CustomerDAO_JDBC implements CustomerDAO {
	Connection dbConnection;
	static final Scanner scan = new Scanner(System.in);

	public CustomerDAO_JDBC(Connection dbconn){
		dbConnection = dbconn;
	}

	@Override
	public Customer getCustomerById(int customer_id) {

		Customer s = new Customer();
		PreparedStatement stmt = null;

		try{
			stmt = dbConnection.prepareStatement("SELECT * FROM Customer WHERE customer_id = (?)");
      stmt.setInt(1, customer_id);
			ResultSet rs = stmt.executeQuery();
			String name = rs.getString("name");
      String contact = rs.getString("contact");
      String address = rs.getString("address");
      int custom_id  = rs.getInt("customer_id");
      s.setName(name);
			s.setContact(contact);
      s.setAddress(address);
      s.setCustomerID(custom_id);
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

			preparedStatement.setInt(1, Customer.getCustomerID());
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
	public void updateCustomer(Customer customer) {
		PreparedStatement prepareStatement = null;
		String sql;
    try{
			int id = customer.getCustomerID();
    System.out.print("New name: ");
    String newName = scan.nextLine();
    System.out.print("New contact: ");
    String newContact = scan.nextLine();
    System.out.print("New address: ");
    String newAddress = scan.nextLine();
    prepareStatement = dbConnection.prepareStatement("UPDATE Customer SET name=(?), contact=(?), address=(?) WHERE customer_id=(?)");
		prepareStatement.setInt(4, id);
    prepareStatement.setString(1, newName);
    prepareStatement.setString(2, newContact);
    prepareStatement.setString(3, newAddress);
		} catch (SQLException e) {
 			System.out.println(e.getMessage());
 		}
		try{
			if (prepareStatement != null) {
				prepareStatement.close();
			}
		} catch (SQLException e) {
 			System.out.println(e.getMessage());
 		}
	}

	@Override
	public ArrayList<Account> getAllAccounts(int customer_id) {
		String sql;
		PreparedStatement stmt = null;
		ArrayList<Account> AccountList = new ArrayList<Account>();
		try{
			stmt = dbConnection.prepareStatement("SELECT * FROM Account WHERE account_customer_id = (?)");
			stmt.setInt(1, customer_id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				//Retrieve by column name
				Account s = new Account();
				int account_customer_id  = rs.getInt("account_customer_id");
				int accountnumber = rs.getInt("accountnumber");
				// Date createdate=rs.getDate("createddate");
				int branch_id=rs.getInt("account_branch_id");
				int balance = rs.getInt("balance");

				s.setCustomerID(account_customer_id);
				s.setAccountNumber(accountnumber);
				// s.setDate(createdate);
				s.setBranchID(branch_id);
				s.setBalance(balance);

				AccountList.add(s);
				// Add exception handling here if more than one row is returned
			}
			return AccountList;
		} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
		}
		return null;
		// Add exception handling when there is no matching record
	}

	@Override
	public ArrayList<Loan> getLoanDetails(int customer_id) {
		String sql;
		Statement stmt = null;
		ArrayList<Loan> loanList = new ArrayList<Loan>();
		ArrayList<Account> accountlist = getAllAccounts(customer_id);
		AccountDAO acc = new AccountDAO_JDBC(dbConnection);
		for(Account s:accountlist){
			ArrayList<Loan> l = new ArrayList<Loan>();
			l=acc.getLoans(s);
			loanList.addAll(l);
		}
		// Add exception handling when there is no matching record
		return loanList;
	}

	@Override
	public ArrayList<Transaction> getTransactionDetails(int customer_id) {
		String sql;
		Statement stmt = null;
		ArrayList<Transaction> transList = new ArrayList<Transaction>();
		ArrayList<Account> accountlist = getAllAccounts(customer_id);
		AccountDAO acc = new AccountDAO_JDBC(dbConnection);
		for(Account s:accountlist){
			ArrayList<Transaction> t = acc.getTransactions(s);
			transList.addAll(t);
		}
		// Add exception handling when there is no matching record
		// for(Transaction s:transList){
		// 	s.print();
		// }
		return transList;
	}

	@Override
	public void SendMoney(int custom_id){
	  System.out.println("Input your account number:");
	  int sender =scan.nextInt();
	  scan.nextLine();
	  System.out.println("Input reciever's account number:");
	  int reciever =scan.nextInt();
	  scan.nextLine();
	  System.out.println("Input your ammount:");
	  float amt =scan.nextFloat();
	  scan.nextLine();
	  AccountDAO acc = new AccountDAO_JDBC(dbConnection);
		TransactionDAO tra = new TransactionDAO_JDBC(dbConnection);
		Transaction tran = new Transaction("sent",(int)amt,sender);
	  acc.TransferMoney(sender,reciever,amt);
		tra.addTransaction(tran);
	  System.out.println("....Money Has been Transfered...");
	}

  @Override
	public void deleteCustomer(Customer customer) {
    PreparedStatement stmt = null;
		int custm_id =  customer.getCustomerID();
    try {
      stmt = dbConnection.prepareStatement("DELETE FROM Customer WHERE id=(?)");
      stmt.setInt(1, custm_id);
      stmt.executeUpdate();
      System.out.println("Deleted row successfully.");
    } catch (SQLException e) {
 			System.out.println(e.getMessage());
 		}
		try{
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
 			System.out.println(e.getMessage());
 		}
	}
}
