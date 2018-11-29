import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class AccountDAO_JDBC implements AccountDAO {
	Connection dbConnection;

	public AccountDAO_JDBC(Connection dbconn){
		dbConnection = dbconn;
	}

	@Override
	public Account getAccountDetails(int accno) {
		Account a = new Account();
		String sql;
		Statement stmt = null;

		try{
			stmt = dbConnection.createStatement();
			sql = "select * from Account where accountnumber=" + accno;
			ResultSet rs = stmt.executeQuery(sql);


			while(rs.next()){
				float balance  = rs.getFloat("balance");
				int  accountnumber = rs.getInt("accountnumber");
				int account_branch_id = rs.getInt("account_branch_id");
				int account_customer_id = rs.getInt("account_customer_id");
				// Date date = rs.getDate("date");

				a.setAccountNumber(accountnumber);
				a.setBalance(balance);
				// a.setDate(date);
				a.setCustomerID(account_customer_id);
				a.setBranchID(account_branch_id);
				break;
			}
			return a;
		}
		catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
    return new Account();
	}

	@Override
	public void CreateAccount(Account a) {
		PreparedStatement preparedStatement = null;
		String sql;
		sql = "INSERT INTO Account(accountnumber, balance, account_customer_id, account_branch_id) values (?,?,?,?)";

		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, a.getAccountNumber());
			preparedStatement.setFloat(2, a.getBalance());
  		// preparedStatement.setDate(3, a.getDate());
  		preparedStatement.setInt(3, a.getCustomerID());
    	preparedStatement.setInt(4, a.getBranchID());

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Account with account number  " + a.getAccountNumber() + ", added to the database");
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

	public void DeductMoney(int accno,float amount) {
		Account a = new Account();
		String sql;
		Statement stmt = null;

		try{
			stmt = dbConnection.createStatement();
			sql = "select * from Account where accountnumber=" + accno;
			ResultSet rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				float balance  = rs.getFloat("balance");
				int  accountnumber = rs.getInt("accountnumber");
				int account_branch_id=rs.getInt("account_branch_id");
				int account_customer_id=rs.getInt("account_customer_id");
				// Date date=rs.getDate("date");

				a.setAccountNumber(accountnumber);
				a.setBalance(balance);
				// a.setDate(date);
				a.setCustomerID(account_customer_id);
				a.setBranchID(account_branch_id);

				break;
				// Add exception handling here if more than one row is returned
			}
			PreparedStatement stmt1= null;
			stmt1 = dbConnection.prepareStatement("Update Account set balance = '"+(a.getBalance()-amount)+"' where accountnumber = "+a.getAccountNumber());
			stmt1.executeUpdate();
			System.out.println("Money Deducted from account number: " + a.getAccountNumber());

			// sql_deduct="Update Account set amount = '"+(a.getBalance()-amount)+"' where accountnumber = '"+a.getAccountNumber()+"'";
			// stmt.executeUpdate(sql_deduct);
			// System.out.println("Money Added to account number: " + a.getAccountNumber());
		}
		catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
	}


public void AddMoney(int accno,float amount) {
		Account a = new Account();
		String sql;
		Statement stmt = null;

		try{
			stmt = dbConnection.createStatement();
			sql = "select * from Account where accountnumber=" + accno;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				//Retrieve by column name
				float balance  = rs.getFloat("balance");
				int  accountnumber = rs.getInt("accountnumber");
				int account_branch_id=rs.getInt("account_branch_id");
				int account_customer_id=rs.getInt("account_customer_id");
				// Date date=rs.getDate("date");

				a.setAccountNumber(accountnumber);
				a.setBalance(balance);
				// a.setDate(date);
				a.setCustomerID(account_customer_id);
				a.setBranchID(account_branch_id);

				break;
				// Add exception handling here if more than one row is returned
			}
			PreparedStatement stmt1= null;
			stmt1 = dbConnection.prepareStatement("Update Account set balance = '"+(a.getBalance()+amount)+"' where accountnumber = "+a.getAccountNumber());
			stmt1.executeUpdate();
	    System.out.println("Money Added to account number: " + a.getAccountNumber());
		}
		catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
	}
	@Override
	public void TransferMoney(int sender,int reciever,float amount){
		// Transac
		DeductMoney( sender, amount);
		AddMoney( reciever, amount);

	}

	@Override
	public ArrayList<Loan> getLoans(Account account) {
		String sql;
		Statement stmt = null;
		int accountnumber = account.getAccountNumber();
		ArrayList<Loan> loans = new ArrayList<Loan>();
		try{
			stmt = dbConnection.createStatement();
			sql = "select * from Loan where loan_account_id=" + accountnumber;
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				Loan s = new Loan();
				int loan_id  = rs.getInt("loan_id");
				float  amount = rs.getFloat("amount");
				String type=rs.getString("type");
				int account_id=rs.getInt("loan_account_id");
				int manager_id=rs.getInt("loan_manager_id");

				s.setID(loan_id);
				s.setAmount((int)amount);
				s.setType(type);
				s.setAccountID(account_id);
				s.setManagerID(manager_id);

				loans.add(s);
				// Add exception handling here if more than one row is returned
			}
			return loans;
		}
		catch (SQLException ex) {
				// handle any errors
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return null;
	}

	@Override
	public ArrayList<Transaction> getTransactions(Account account) {
		String sql;
		Statement stmt = null;
		ArrayList<Transaction> trans = new ArrayList<Transaction>();
		int accountnumber = account.getAccountNumber();
		try{
			stmt = dbConnection.createStatement();
			sql = "select * from Transaction where transaction_accountnumber=" + accountnumber;
			ResultSet rs = stmt.executeQuery(sql);
			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				Transaction s = new Transaction();

				// Date date = rs.getDate("transactiondate");
				float amount = rs.getFloat("amount");
				int account_no = rs.getInt("transaction_accountnumber");
				int transaction_id  = rs.getInt("transaction_id");

				// s.setDate(date);
				s.setAmount((int)amount);
				s.setAccountNo(account_no);
				s.setTransactionID(transaction_id);

				trans.add(s);
				// Add exception handling here if more than one row is returned
			}
			return trans;
		}
		catch (SQLException ex) {
				// handle any errors
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return null;
	}
}
