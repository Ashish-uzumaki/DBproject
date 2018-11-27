import java.lang.*;

public class Transaction{
  String date;
  String type;
  int transaction_id;
  int account_no;
  int amount;
	public Transaction() { }
	public Transaction ( String date,String typ,int id,int acc_no,int amt){
     date = na;
     type = typ;
     transaction_id = id;
     account_no = acc_no;
     amount = amt;
     }
	public String getDate() {
     return date;
    }
	public void setDate(String s){
     date = s;
    }
	public String getType() {
     return type;
    }
	public void setType(String s){
     type = s;
    }
  public int getTransactionId() {
       return transaction_id;
      }
  public void setTransactionId(int s){
       transaction_id = s;
      }
  public int getAmount() {
         return amount;
      }
  public void setAmount(int s){
         amount = s;
      }
  public int getAccountNo() {
         return account_no;
      }
  public void setAccountNo(int s){
         account_no = s;
      }
	public void print(){
     System.out.println("Transaction_id" + transaction_id);
     System.out.println("Accountno=" + account_no);
     System.out.println("Amount=" + amount);
     System.out.println("Date=" + date);
     System.out.println("type=" + type);
   }
};
