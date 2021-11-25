package tec.bases.cli;

import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;
import tec.bases.cli.loanCLI.*;

@Command(
    name = "BlockbusterAPP",
    subcommands = {
        //Aqui van todos los comandos por hacer.
        GetAllLoansCommand.class,
        CreateLoanCommand.class,
        GetLoanByIDCommand.class,
        DeleteLoanCommand.class,
        HelpCommand.class
    },
    description = "Manage the blockbuster info")


public class MainCommand implements Runnable {

    @Override
    public void run() {}
}
