import java.lang.*;
import java.util.*;

public interface TransactionDAO {
	public void addTransaction(Transaction transaction);
  // public List<Transaction> findAll();
	public Transaction getTransactionById(int transaction_id);
  // public ArrayList<Transaction> getTransactionByDate();
	public ArrayList<Transaction> getTansactionByAccount(Account s);
}
