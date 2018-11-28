import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;

public class CustomerScreen{
  static final Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		try{
			DAO_Factory daoFactory = new DAO_Factory();

			daoFactory.activateConnection();

			CustomerDAO cdao = daoFactory.getCustomerDAO();
      LoanDAO dao = daoFactory.getLoanDAO();
      AccountDAO adao = daoFactory.getAccountDAO();
      // EnsuranceDAO edao = daoFactory.getEnsuranceDAO();
      TransactionDAO tdao = daoFactory.getTransactionDAO();
      boolean cnt = true;
      System.out.println("Insert Customer_ID:");
      int id = scan.nextInt();
      do {
        System.out.println("Which operation would you like to perform:");
        System.out.println("1: Previous Transaction details");//Customer transaction table
        System.out.println("2: Account details");//Account table
        System.out.println("3: Loan details");//Loan table
        System.out.println("4: Ensurance details");//ensurance table
        System.out.println("5: Transfer Money");//transaction table
        System.out.println("6: Quit");
        System.out.print("Your option: ");

        int opt = scan.nextInt();
        System.out.println();

        switch(opt) {
          case 1:
            cdao.getTransactionDetails(id);
            break;

          case 2:
            cdao.getAllAccounts(id);
            break;

          case 3:
            cdao.getLoanDetails(id);
            break;

          case 4:
            cdao.getEnsuranceDetails(id);
            break;

          case 5:
            cdao.DoTransfer(id);
            break;

          case 6:
            cnt = false;
            break;

          default:
            System.out.println("Incorrect option.");
        }
        System.out.println();
      } while (cnt);
			daoFactory.deactivateConnection();
		}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
		}
	}//end main
}//end FirstExample
