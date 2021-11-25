package tec.bases.dao.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import tec.bases.dao.FilmDAO;
import tec.bases.entity.Film;

public class FilmDAOimplementation extends GenericDAOimplementation<Film, Long> implements FilmDAO {

    private final DataSource dataSource;



    public FilmDAOimplementation(DataSource _dataSource) {
        this.dataSource = _dataSource;
    }

    private Connection getDBconnection() {
        try { 
            return this.dataSource.getConnection();
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
            throw new RuntimeException();
        }
    }

    



    @Override
    public List<Film> findAll() throws SQLException {
        String selectStringQuerry = "SELECT * FROM blockbuster.film";
        
        Connection dbConnection = getDBconnection();
        try (PreparedStatement findFilm = dbConnection.prepareStatement(selectStringQuerry)) {
            dbConnection.setAutoCommit(false);
            var resultSet = findFilm.executeQuery();
            dbConnection.commit();
            return resultSetToList(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
        }
        return  Collections.emptyList();
    }

    @Override
    public Optional<Film> findByID(Long id) throws SQLException {
        String findStringQuerry = 
            "SELECT * FROM blockbuster.Film WHERE blockbuster.Film.film_cod = ?";
        
        Connection dbConnection = getDBconnection();
        try (PreparedStatement findFilm = dbConnection.prepareStatement(findStringQuerry)) {
            dbConnection.setAutoCommit(false);
            findFilm.setLong(1, id);
            var resultSet = findFilm.executeQuery();
            dbConnection.commit();
            resultSet.next();
            return Optional.of(resultSetToEntity(resultSet));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
        }
        return Optional.empty();
    }

    @Override
    public void save(Film t) throws SQLException {
        String saveStringQuerry = 
            "INSERT INTO blockbuster.Film (film_tittle, film_releaseDate, film_catID) " +
                "VALUES (?, ?, ?)";
        
        Connection dbConnection = getDBconnection();
        try (PreparedStatement saveFilm = dbConnection.prepareStatement(saveStringQuerry)) {
            dbConnection.setAutoCommit(false);
            saveFilm.setString(1, t.getFilmTittle());
            saveFilm.setDate(2, t.getFilmReleaseDate());
            saveFilm.setLong(3, t.getFilmCategory());

            saveFilm.executeUpdate();
            dbConnection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
        }
    }

    @Override
    public void update(Film t) throws SQLException {
        String updateStringQuerryTittle = "UPDATE blockbuster.Film AS film " + 
            "SET film.film_tittle = ? WHERE film.film_cod = ?";

        String updateStringQuerryDate = "UPDATE blockbuster.Film AS film " + 
            "SET film.film_releaseDate = ? WHERE film.film_cod = ?";
        
        String updateStringQuerryCat = "UPDATE blockbuster.Film AS film " + 
            "SET film.film_catID = ? WHERE film.film_cod = ?";

        
        Connection dbConnection = getDBconnection();
        try (
            PreparedStatement updateTittle = dbConnection.prepareStatement(updateStringQuerryTittle);
            PreparedStatement updateDate = dbConnection.prepareStatement(updateStringQuerryDate);
            PreparedStatement updateCat = dbConnection.prepareStatement(updateStringQuerryCat)
            ) {
                dbConnection.setAutoCommit(false);
                updateTittle.setString(1, t.getFilmTittle());
                updateTittle.setLong(2, t.getFilmID());
                updateTittle.executeUpdate();

                updateDate.setDate(1, t.getFilmReleaseDate());
                updateDate.setLong(2, t.getFilmID());
                updateDate.executeUpdate();

                updateCat.setLong(1, t.getFilmCategory());
                updateCat.setLong(2, t.getFilmID());
                updateCat.executeUpdate();

                dbConnection.commit();
             } catch (SQLException e) {
                System.out.println(e.getMessage());
                dbConnection.rollback();
             }
    }

    @Override
    public void delete(Long id) throws SQLException {
        String deleteStringQuerry = "DELETE FROM blockbuster.Film WHERE blockbuster.Film.film_cod = ?";
        
        Connection dbConnection = getDBconnection();
        try (PreparedStatement deleteFilm = dbConnection.prepareStatement(deleteStringQuerry)) {
            dbConnection.setAutoCommit(false);
            deleteFilm.setLong(1, id);
            deleteFilm.executeUpdate();
            dbConnection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
        } 
    }

    @Override
    protected Film resultSetToEntity(ResultSet _resultSet) throws SQLException {
        var filmID = _resultSet.getLong("film_cod");
        var filmTittle = _resultSet.getString("film_tittle");
        var filmDate = _resultSet.getDate("film_releaseDate");
        var catID = _resultSet.getLong("film_catID");

        return new Film(filmID, filmTittle, filmDate, catID);
    }

    @Override
    protected List<Film> resultSetToList(ResultSet _resultSet) throws SQLException {
        List<Film> myFilms = new ArrayList<>();
        while (_resultSet.next() ) {
            myFilms.add(resultSetToEntity(_resultSet));
        }
        return myFilms;

    };
}
    
    
