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
      // LoanDAO cdao = daoFactory.getLoanDAO();
      // AccountDAO cdao = daoFactory.getAccountDAO();
      // EnsuranceDAO cdao = daoFactory.getEnsuranceDAO();
      boolean cnt = true;
      do {
        System.out.println("Which operation would you like to perform:");
        System.out.println("1: Transaction details");//Customer transaction table
        System.out.println("2: Account details");//Account table
        System.out.println("3: Loan details");//Loan table
        System.out.println("4: Ensurance details");//ensurance table
        System.out.println("5: Quit");
        System.out.print("Your option: ");

        int opt = scan.nextInt();
        System.out.println();

        switch(opt) {
          case 1:
            break;

          case 2:
            break;

          case 3:
            break;

          case 4:
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
