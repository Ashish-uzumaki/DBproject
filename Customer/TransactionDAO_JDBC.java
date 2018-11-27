import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class TransactionDAO_JDBC implements CustomerDAO {
	Connection dbConnection;

	public Transaction_JDBC(Connection dbconn){
		dbConnection = dbconn;
	}
	static final Scanner scan = new Scanner(System.in);

	@Override
	public Transaction getTransactionById(int transaction_id) {

		Transaction s = new Transaction();
		String sql;
		Statement stmt = null;

		try{
			stmt = dbConnection.createStatement();
			sql = "SELECT * FROM Transaction WHERE transaction_id = (?)";
      stmt.setInt(1, transaction_id);
			ResultSet rs = stmt.executeQuery(sql);
			String date = rs.getDate("transactiondate");
      int amount = rs.getAmount("amount");
      String account_no = rs.getString("transaction_accountnumber");
      int transaction_id  = rs.getInt("transaction_id");
      s.setDate(date);
			s.setAmount(amount);
      s.setAccountNo(account_no);
      s.setTransactionID(transaction_id);
		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return s;
	}

	@Override
	public void addTransaction(Transaction Transaction) {
		PreparedStatement preparedStatement = null;
		String sql;
		sql = "insert into Transaction(transaction_id, transactiondate, transaction_accountnumber,amount ) values (?,?,?,?)";
		try {
			preparedStatement = dbConnection.prepareStatement(sql);

			preparedStatement.setInt(1, Transaction.getTransactionId());
			preparedStatement.setString(2, Transaction.getDate());
      preparedStatement.setString(3, Transaction.getAccountNo());
      preparedStatement.setString(4, Transaction.getAmount());
			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Transaction added to the database");
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
	public void getTansactionDetails(int customerid) {
		PreparedStatement preparedStatement = null;
		String sql;
		sql = "";
		try {
			preparedStatement = dbConnection.prepareStatement(sql);

			preparedStatement.setInt(1, Transaction.getTransactionId());
			preparedStatement.setString(2, Transaction.getDate());
      preparedStatement.setString(3, Transaction.getAccountNo());
      preparedStatement.setString(4, Transaction.getAmount());
			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Transaction added to the database");
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
