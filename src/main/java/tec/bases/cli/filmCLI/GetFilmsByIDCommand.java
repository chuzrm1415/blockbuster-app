package tec.bases.cli.filmCLI;

import java.sql.SQLException;
import java.util.Optional;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bases.ApplicationContext;
import tec.bases.entity.Film;

@Command(name = "movrid", description = "get film by ID")

public class GetFilmsByIDCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "<film ID>", description = "film ID")
    private int filmID;

    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();
        try {
            var film = blockbuster.findFilmsByID(Long.valueOf(filmID));
            showInfo(film);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private void showInfo(Optional<Film> _film) {
        System.out.println("FILM_ID          TITTLE             DATE             CATEGORIA");
        if (_film.isPresent()) {
            System.out.println(_film.get().toString());
        }
    }
}
