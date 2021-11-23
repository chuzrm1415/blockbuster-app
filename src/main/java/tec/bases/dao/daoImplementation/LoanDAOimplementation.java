package tec.bases.dao.daoImplementation;

import tec.bases.entity.Loan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import tec.bases.dao.LoanDAO;

public class LoanDAOimplementation extends GenericDAOimplementation<Loan, Long> implements LoanDAO {

    @Override
    public List<Loan> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Loan> findByID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Loan t) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Optional<Loan> update(Loan t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected Loan resultSetToEntity(ResultSet _resultSet) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected List<Loan> resultSetToList(ResultSet _resultSet) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    
}
