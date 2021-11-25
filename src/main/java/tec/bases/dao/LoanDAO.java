package tec.bases.dao;

import java.sql.SQLException;
import java.util.List;

import tec.bases.entity.Loan;

public interface LoanDAO extends GenericDAO<Loan, Long> {

    List<Loan> findByFilm(Long filmID) throws SQLException;

    void deleteLoan(Long filmID, Long clientID) throws SQLException;

}
