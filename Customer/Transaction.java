import java.lang.*;
import java.util.*;
public class Transaction{
  // Date date;
  String type;
  int transaction_id;
  int account_no;
  int amount;
	public Transaction() { }
	public Transaction (String typ,int amt,int acc_no){
     // date = date;
     type = "transfer";
     // transaction_id = id;
     account_no = acc_no;
     amount = amt;
     }
	// public Date getDate() {
  //    return date;
  //   }
	// public void setDate(Date s){
  //    date = s;
  //   }
	public String getType() {
     return type;
    }
	public void setType(String s){
     type = s;
    }
  public int getTransactionID() {
       return transaction_id;
      }
  public void setTransactionID(int s){
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

     System.out.println("Transaction_id=" + transaction_id);
     System.out.println("Money sent from:");
     System.out.println("Accountno=" + account_no);
     System.out.println("Amount=" + amount);
     // System.out.println("Date=" + date);
     // System.out.println("type=" + type);
     System.out.println("--------");
   }
};
