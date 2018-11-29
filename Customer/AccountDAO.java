import java.lang.*;
import java.util.List;
import java.util.ArrayList;

public interface AccountDAO {
	public Account getAccountDetails(int accno);
	public void CreateAccount(Account a);
	public void DeductMoney(int accno,float amount);
	public void AddMoney(int accno,float amount);
	public ArrayList<Transaction> getTransactions(Account account);
	public ArrayList<Loan> getLoans(Account account);
	public void TransferMoney(int sender,int reciever,float amount);
}
