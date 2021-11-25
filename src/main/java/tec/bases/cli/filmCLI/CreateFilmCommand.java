package tec.bases.cli.filmCLI;

import java.sql.Date;
import java.sql.SQLException;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bases.ApplicationContext;
import tec.bases.entity.Film;

@Command(name = "movc", description = "Insert a film")

public class CreateFilmCommand implements Runnable {

    @CommandLine.Parameters(index = "0", paramLabel = "<tittle>",description = "movie tittle")
    private String tittle;

    @CommandLine.Parameters(index = "1", paramLabel = "<date>",description = "release date")
    private String date;

    @CommandLine.Parameters(index = "2", paramLabel = "<category>",description = "category")
    private Long cat;

    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();
        try {
            blockbuster.saveFilm(new Film(tittle, Date.valueOf(date), cat));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
