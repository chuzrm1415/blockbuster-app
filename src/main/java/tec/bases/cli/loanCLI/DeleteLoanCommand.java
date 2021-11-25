package tec.bases.cli.loanCLI;

import java.sql.SQLException;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bases.ApplicationContext;

@Command(name = "loand", description = "Delete a film loan to a client")

public class DeleteLoanCommand implements Runnable {

    @CommandLine.Parameters(index = "0", paramLabel = "<filmID>", description = "FilmID")
    private Long filmID;

    @CommandLine.Parameters(index = "1", paramLabel = "<clientID>", description = "clientID")
    private Long clientID;



    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();
        try {
            blockbuster.deleteLoan(filmID, clientID);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
