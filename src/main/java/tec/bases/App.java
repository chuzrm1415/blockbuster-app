package tec.bases;

import java.sql.SQLException;
import java.util.List;

import tec.bases.entity.Loan;

public class App 
{

    public static void main( String[] args ) throws SQLException {
        ApplicationContext appContext = new ApplicationContext();
        toStringLoans( appContext.getLoans());
        System.out.println("Imprimio?");
    }

    private static void toStringLoans(List<Loan> myloans) {
        for (int i = 0; i < myloans.size(); i++ ) {
            myloans.get(i).toString();
        }
    }
}
