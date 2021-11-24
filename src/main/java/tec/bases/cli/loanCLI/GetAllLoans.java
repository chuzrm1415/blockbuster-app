package tec.bases.cli.loanCLI;

import java.sql.SQLException;
import java.util.List;

import picocli.CommandLine.Command;
import tec.bases.ApplicationContext;
import tec.bases.entity.Loan;

@Command(name = "loanr",description = "Return all loans")

public class GetAllLoans implements Runnable {

    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();
        try {
            var loanList = blockbuster.getAllLoans();
            showInfo(loanList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showInfo(List<Loan> _list) {
        System.out.println("LOAN_ID    FILM_ID    CLIENT_ID        DATE        DEVOLUTION_DATE     STATE");
        if ( ! _list.isEmpty() ) {
            for (int indx = 0; indx < _list.size(); indx++) {
                System.out.println( _list.get(indx).toString());
            }
        }
    }
    
}
