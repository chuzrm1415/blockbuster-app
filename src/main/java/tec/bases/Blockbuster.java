package tec.bases;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import tec.bases.dao.*;
import tec.bases.entity.*;

public class Blockbuster {

    private LoanDAO loanDao;
    private CategoryDAO catDao;
    private FilmDAO filmDao;

    public Blockbuster(LoanDAO _loanDao, CategoryDAO _catDao, FilmDAO _filmDao) {
        this.loanDao = _loanDao;
        this.catDao = _catDao;
        this.filmDao = _filmDao;
    }

    // Loans Methods...
    public List<Loan> getAllLoans() throws SQLException {
        return this.loanDao.findAll();
    }

    public void saveLoan (Loan _loan) throws SQLException {
        this.loanDao.save(_loan);
    }

    public List<Loan> findLoanByID(long _id) throws SQLException {
        List<Loan> mylist = this.loanDao.findByFilm(_id);
        return mylist;
    }

    public void deleteLoan(Long _filmID, Long _clientID) throws SQLException {
        this.loanDao.deleteLoan(_filmID, _clientID);
    }


    
    //Category Methods...
    public void saveCategory(Category _cat) throws SQLException {
        this.catDao.save(_cat);
    }

    public List<Category> getAllCategorys() throws SQLException {
        return this.catDao.findAll();
    }

    public Optional<Category> findCategoryByID(Long _id) throws SQLException {
        return this.catDao.findByID(_id);
    }

    public void deleteCategory(Long _id) throws SQLException {
        this.catDao.delete(_id);
    }

    public void updateCategory(Category _cat) throws SQLException {
        this.catDao.update(_cat);
    }


    //Film Methods...
    public void saveFilm(Film _film) throws SQLException {
        this.filmDao.save(_film);
    }

    public List<Film> getAllFilms() throws SQLException {
        return this.filmDao.findAll();
    }

    public Optional<Film> findFilmsByID(Long _id) throws SQLException {
        return this.filmDao.findByID(_id);
    }

    public void deleteFilm(Long _id) throws SQLException {
        this.filmDao.delete(_id);
    }

    public void updateFilm(Film _film) throws SQLException {
        this.filmDao.update(_film);
    }
}
