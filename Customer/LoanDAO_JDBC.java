import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.*;

public class LoanDAO_JDBC implements LoanDAO {
	Connection dbConnection;

	public LoanDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}
	@Override
	public Loan getLoanByKey(int ld) {
		Loan s = new Loan();
		String sql;
		Statement stmt = null;

		try{
			stmt = dbConnection.createStatement();
			sql = "select * from Loan where loan_id=" + ld;
			ResultSet rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set

			while(rs.next()){
				//Retrieve by column name
				int loan_id  = rs.getInt("loan_id");
				int  amount = rs.getInt("amount");
				String type=rs.getString("type");
				int account_id=rs.getInt("loan_account_id");
				int manager_id=rs.getInt("loan_manager_id");

				s.setID(loan_id);
				s.setAmount(amount);
				s.setType(type);
				s.setAccountID(account_id);
				s.setManagerID(manager_id);

				break;
				// Add exception handling here if more than one row is returned
			}
			return s;
		}
		catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
    return new Loan();
	}

	// @Override
	// public Loan getLoanByAccount(Account account) {
	// 	String sql;
	// 	Statement stmt = null;
	// 	int accountnumber = account.getAccountNumber();
	// 	ArrayList<Loan> loans = new ArrayList<Loan>();
	// 	try{
	// 		stmt = dbConnection.createStatement();
	// 		sql = "select * from Loan where accountnumber=" + accountnumber;
	// 		ResultSet rs = stmt.executeQuery(sql);
	//
	// 		//STEP 5: Extract data from result set
	//
	// 		while(rs.next()){
	// 			//Retrieve by column name
	// 			Loan s = new Loan();
	// 			int loan_id  = rs.getInt("loan_id");
	// 			int  amount = rs.getInt("amount");
	// 			String type=rs.getString("type");
	// 			int account_id=rs.getInt("loan_account_id");
	// 			int manager_id=rs.getInt("loan_manager_id");
	//
	// 			s.setId(loan_id);
	// 			s.setAmount(amount);
	// 			s.setType(type);
	// 			s.setAccountId(account_id);
	// 			s.setManagerId(manager_id);
	//
	// 			loans.add(s);
	// 			// Add exception handling here if more than one row is returned
	// 		}
	// 		return loans;
	// 	}
	// 	catch (SQLException ex) {
	// 	    // handle any errors
	// 	    System.out.println("SQLException: " + ex.getMessage());
	// 	    System.out.println("SQLState: " + ex.getSQLState());
	// 	    System.out.println("VendorError: " + ex.getErrorCode());
	// 	}
	// 	// Add exception handling when there is no matching record
  //   return new Loan();
	// }

	@Override
	public void applyLoan(Loan a) {
		PreparedStatement preparedStatement = null;
		String sql;
		sql = "INSERT INTO Loan(loan_id, amount, type, loan_account_id, loan_manager_id) values (?,?,?,?,?)";

		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, a.getID());
			preparedStatement.setInt(2, a.getAmount());
  		preparedStatement.setString(3, a.getType());
  		preparedStatement.setInt(4, a.getAccountID());
    	preparedStatement.setInt(5, a.getManagerID());

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Loan: Id " + a.getID() + ", added to the database");
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
