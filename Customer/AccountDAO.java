import java.lang.*;
import java.util.List;

public interface LoanDAO {
	public Account getAccountDetails(int accno);
	public void CreateAccount(Account a);
	public void DeductMoney(int accno,int amount);
	public void AddMoney(int accno,int amount);
}
