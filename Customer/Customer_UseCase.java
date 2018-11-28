import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;

public class Customer_UseCase{
  public void Account_details(ArrayList<Account> acc){
    for(Account a: acc){
      a.print();
    }
  }
  public void Loan_details(ArrayList<Loan> lon){
    for(Account a: lon){
      a.print();
    }
  }
  public void Transaction_details(ArrayList<Transaction> tra){
    for(Account a: tra){
      a.print();
    }
  }
  public void Ensurance_details(ArrayList<Loan> ens){
    for(Account a: ens){
      a.print();
    }
  }
}
