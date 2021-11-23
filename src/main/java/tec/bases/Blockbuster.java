package tec.bases;

import java.util.List;

import tec.bases.dao.LoanDAO;
import tec.bases.entity.Loan;

public class Blockbuster {

    private LoanDAO loanDao;

    public Blockbuster(LoanDAO _loanDao) {
        this.loanDao = _loanDao;
    }

    public List<Loan> getAllLoans() {
        return this.loanDao.findAll();
    }
    
}
