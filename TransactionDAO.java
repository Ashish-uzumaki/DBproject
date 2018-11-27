import java.lang.*;
import java.util.List;

public interface TransactionDAO {
	public void addTransaction(Transaction transaction);
  public List<Transaction> findAll();
	public Transaction getTransactionById(int transaction_id);
  public List<Transaction> getTransactionByDate();
	public List<Transaction> getTransactionByAccount();
}
