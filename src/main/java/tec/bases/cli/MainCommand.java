package tec.bases.cli;

import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;
import tec.bases.cli.loanCLI.*;
import tec.bases.cli.categoryCLI.*;
import tec.bases.cli.filmCLI.*;

@Command(
    name = "BlockbusterAPP",
    subcommands = {
        //Loan Commands...
        GetAllLoansCommand.class,
        CreateLoanCommand.class,
        GetLoanByIDCommand.class,
        DeleteLoanCommand.class,

        //Category Commands...
        CreateCategoryCommand.class,
        DeleteCategoryCommand.class,
        GetAllCategorysCommand.class,
        GetCategoryByIDCommand.class,
        UpdateCategoryCommand.class,

        //Film Commands...
        CreateFilmCommand.class,
        GetAllFilmsCommand.class,
        GetFilmsByIDCommand.class,
        DeleteFilmCommand.class,
        UpdateFilmCommand.class,

        //Help Command...
        HelpCommand.class
    },
    description = "Manage the blockbuster info")


public class MainCommand implements Runnable {

    @Override
    public void run() {}
}
