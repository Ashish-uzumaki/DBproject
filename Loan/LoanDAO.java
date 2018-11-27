import java.lang.*;
import java.util.List;

public interface LoanDAO {
	public Loan getLoanByKey(int ld);
	public void applyLoan(Loan  a);
	// public void updateStudent(Student student);
	// public void deleteStudent(Student student);

}
