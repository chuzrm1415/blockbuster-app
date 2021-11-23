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

    public List<Loan> getAllLoans() throws SQLException {
        return this.loanDao.findAll();
    }
}
