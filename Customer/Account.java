import java.lang.*;
import java.util.Date;

public class Account{
  float balance;
  int accountnumber;
  int account_branch_id;
  int account_customer_id;
  // Date date=new java.util.Date();


	public Account() { }
	public Account (int accno, int bal, int branch_id, int customer_id){

    accountnumber = accno;
    balance = bal;
    // date = d;
    account_branch_id = branch_id;
    account_customer_id = customer_id;

  }
  public int getAccountNumber() { return accountnumber; }
  public void setAccountNumber(int accno){  accountnumber = accno; }

  public float getBalance() { return balance; }
  public void setBalance(float bal){ balance = bal; }

  public int getBranchID() { return account_branch_id; }
  public void setBranchID(int bid){ account_branch_id= bid; }

  public int getCustomerID() { return account_customer_id; }
  public void setCustomerID(int cid){ account_customer_id = cid; }

  // public Date getDate() { return date; }
  // public void setDate(Date d){ date = d; }


	public void print(){ System.out.println("Account Number =" + accountnumber); System.out.println("Balance =" + balance);}
};
