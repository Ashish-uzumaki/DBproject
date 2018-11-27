import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class AccountDAO_JDBC implements AccountDAO {
	Connection dbConnection;

	public AccountDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
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
    
			//STEP 5: Extract data from result set


			while(rs.next()){
				//Retrieve by column name
				float balance  = rs.getFloat("balance");
				int  accountnumber = rs.getInt("accountnumber");
				int account_branch_id=rs.getInt("account_branch_id");
				int account_customer_id=rs.getInt("account_customer_id");
				Date date=rs.getDate("date");	

				a.setAccountNumber(accountnumber);
				a.setBalance(balance);
				a.setDate(date);
				a.setCustomerId(account_customer_id);
				a.getBranchId(account_branch_id);
				
				break;
				// Add exception handling here if more than one row is returned
			}
			return a;
		} 
		catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
    return new Account();
	}

	@Override
	public void CreateAccount(Account a) {
		PreparedStatement preparedStatement = null;
		String sql;
		sql = "INSERT INTO Account(accountnumber, balance, date, account_customer_id, account_branch_id) values (?,?,?,?,?)";

		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, a.getAccountNumber());
			preparedStatement.setInt(2, a.getBalance());
    		preparedStatement.setString(3, a.getDate());
    		preparedStatement.setInt(4, a.getCustomerId());
        	preparedStatement.setInt(5, a.getBranchId());

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

	public void DeductMoney(int accno,int amount) {
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
				Date date=rs.getDate("date");	

				a.setAccountNumber(accountnumber);
				a.setBalance(balance);
				a.setDate(date);
				a.setCustomerId(account_customer_id);
				a.getBranchId(account_branch_id);
				
				break;
				// Add exception handling here if more than one row is returned
			}

			sql_deduct="Update Account set amount = "+(a.getBalance()-amount)+" where accountnumber = "+a.getAccountNumber();
			stmt.executeUpdate(sql_deduct);

		    System.out.println("Money Deducted from account number: " + a.getAccountNumber());

		} 
		catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
	}


public void AddMoney(int accno,int amount) {
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
				Date date=rs.getDate("date");	

				a.setAccountNumber(accountnumber);
				a.setBalance(balance);
				a.setDate(date);
				a.setCustomerId(account_customer_id);
				a.getBranchId(account_branch_id);
				
				break;
				// Add exception handling here if more than one row is returned
			}

			sql_deduct="Update Account set amount = "+(a.getBalance()+amount)+" where accountnumber = "+a.getAccountNumber();
			stmt.executeUpdate(sql_deduct);

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



}


