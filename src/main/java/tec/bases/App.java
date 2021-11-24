package tec.bases;

import picocli.CommandLine;
import tec.bases.cli.MainCommand;

public class App 
{

    public static void main( String[] args ) {
        CommandLine cmd = new CommandLine(new MainCommand());
        cmd.setExecutionStrategy(new CommandLine.RunAll());
        cmd.execute(args);

        if (args.length == 0) { cmd.usage(System.out); }
    }
}
