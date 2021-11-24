package tec.bases.cli.loanCLI;

import java.sql.Date;
import java.sql.SQLException;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bases.ApplicationContext;
import tec.bases.entity.Loan;

@Command(name = "loanc", description = "Insert a loan")

public class CreateLoanCommand implements Runnable {
    
    @CommandLine.Parameters(index = "0", paramLabel = "<film ID>", description = "Film ID")
    private int filmID;

    @CommandLine.Parameters(index = "1",paramLabel = "<client ID>",description = "Client ID")
    private int clientID;

    @CommandLine.Parameters(index = "2",paramLabel = "<date>",description = "loan date")
    private String date;



    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();
        Date newDate = Date.valueOf(date);
        Loan _loan = new Loan(filmID, clientID, newDate);
        try {
            blockbuster.saveLoan(_loan);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    
}
