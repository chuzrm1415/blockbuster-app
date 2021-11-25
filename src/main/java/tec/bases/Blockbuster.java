package tec.bases;

import java.sql.SQLException;
import java.util.List;
import tec.bases.dao.LoanDAO;
import tec.bases.entity.Loan;

public class Blockbuster {

    private LoanDAO loanDao;

    public Blockbuster(LoanDAO _loanDao) {
        this.loanDao = _loanDao;
    }

    // Metodos para Loans.......
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

    public void deleteLoan(Long filmID, Long clientID) throws SQLException {
        this.loanDao.deleteLoan(filmID, clientID);
    }
}
