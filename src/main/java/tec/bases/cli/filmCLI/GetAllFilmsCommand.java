package tec.bases.cli.filmCLI;

import java.sql.SQLException;
import java.util.List;
import tec.bases.entity.Film;
import picocli.CommandLine.Command;
import tec.bases.ApplicationContext;

@Command(name = "movr", description = "Show all film")

public class GetAllFilmsCommand implements Runnable {

    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();
        try {
            var filmList = blockbuster.getAllFilms();
            showInfo(filmList);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private void showInfo(List<Film> _list) {
        System.out.println("FILM_ID          TITTLE             DATE             CATEGORIA");
        if (! _list.isEmpty()) {
            for (int indx = 0; indx < _list.size(); indx++) {
                System.out.println( _list.get(indx).toString());
            }
        }
    }
    
}
