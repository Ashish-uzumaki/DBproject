import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class TransactionDAO_JDBC implements TransactionDAO {
	Connection dbConnection;

	public TransactionDAO_JDBC(Connection dbconn){
		dbConnection = dbconn;
	}
	static final Scanner scan = new Scanner(System.in);

	@Override
	public Transaction getTransactionById(int transaction_id) {

		Transaction s = new Transaction();
		String sql;
		PreparedStatement stmt = null;

		try{
			stmt = dbConnection.prepareStatement("SELECT * FROM Transaction WHERE transaction_id = (?)");
      stmt.setInt(1, transaction_id);
			ResultSet rs = stmt.executeQuery();
			// Date date = rs.getDate("transactiondate");
      int amount = rs.getInt("amount");
      int account_no = rs.getInt("transaction_accountnumber");
      int transact_id  = rs.getInt("transaction_id");
      // s.setDate(date);
			s.setAmount(amount);
      s.setAccountNo(account_no);
      s.setTransactionID(transact_id);
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
		sql = "insert into Transaction(type,transaction_accountnumber,amount ) values (?,?,?)";
		try {
			preparedStatement = dbConnection.prepareStatement(sql);

			// preparedStatement.setInt(1, Transaction.getTransactionID());
			// preparedStatement.setDate(2, Transaction.getDate());
			preparedStatement.setString(1, Transaction.getType());
      preparedStatement.setInt(2, Transaction.getAccountNo());
      preparedStatement.setInt(3, Transaction.getAmount());
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
	public ArrayList<Transaction> getTansactionByAccount(Account s) {
		String sql;
		PreparedStatement stmt = null;
		ArrayList<Transaction> TransactionList = new ArrayList<Transaction>();
		try{
			stmt = dbConnection.prepareStatement("SELECT * FROM Transaction WHERE transaction_accountnumber = (?)");
			stmt.setInt(1, s.getAccountNumber());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				//Retrieve by column name
				Transaction t = new Transaction();
				int transaction_id  = rs.getInt("transaction_id ");
				int transaction_accountnumber = rs.getInt("transaction_accountnumber");
				String type = rs.getString("type");
				// Date transactiondate=rs.getDate("transactiondate");
				int amount = rs.getInt("amount");

				// t.setDate(transactiondate);
				t.setTransactionID(transaction_id);
				t.setAccountNo(transaction_accountnumber);
				t.setAmount(amount);
				t.setType(type);

				TransactionList.add(t);
				// Add exception handling here if more than one row is returned
			}
			return TransactionList;
		} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return null;
}
}
