import java.lang.*;

public class Loan{
  int id;
  int amount;
  String type;
  int account_id;
  int manager_id;

	public Loan() { }
	public Loan (int loan_id, int amo, String t, int acc_id, int mgr_id){

    id = loan_id;
    amount = amo;
    type = t;
    account_id = acc_id;
    manager_id = mgr_id;

  }
  public int getID() { return id; }
  public void setID(int loan_id){ id = loan_id; }

  public int getAmount() { return amount; }
  public void setAmount(int amo){ amount=amo; }

  public String getType() { return type; }
  public void setType(String s){ type = s; }

  public int getAccountID() { return account_id; }
  public void setAccountID(int s){ account_id = s; }

  public int getManagerID() { return manager_id; }
  public void setManagerID(int s){ manager_id = s; }


	public void print(){ System.out.println("Id=" + id); System.out.println("amount =" + amount);}
};
