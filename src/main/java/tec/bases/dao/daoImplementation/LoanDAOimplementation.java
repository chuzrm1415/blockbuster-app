package tec.bases.dao.daoImplementation;

import tec.bases.entity.Loan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.CallableStatement;

import tec.bases.dao.LoanDAO;

public class LoanDAOimplementation extends GenericDAOimplementation<Loan, Long> implements LoanDAO {

    private final DataSource dataSource;

    // Loans Querrys
    private static final String FIND_ALL_LOAN_PROC = "{CALL show_loans()}";


    public LoanDAOimplementation(DataSource _dataSource) {
        this.dataSource = _dataSource;
    }



    @Override
    public List<Loan> findAll() {
        List<Loan> myLoans = new ArrayList<>();
        Connection dbConnection = null;

        try {
            dbConnection = this.dataSource.getConnection();
            CallableStatement callStat = (CallableStatement) dbConnection.prepareCall(FIND_ALL_LOAN_PROC);
            var resultSet = callStat.executeQuery();
            return resultSetToList(resultSet);
        } catch (Exception e) {
            try {
                System.out.println(e.getMessage());
                dbConnection.rollback();
            } catch (SQLException sqlEx) {
                throw new RuntimeException(sqlEx);
            }
        }
        return myLoans;
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
        var loanID = _resultSet.getInt("loan_ID");
        var filmID = _resultSet.getInt("loan_filmID");
        var clientID = _resultSet.getInt("loan_clientID");
        var date = _resultSet.getDate("loan_date");
        var devolDate = _resultSet.getDate("loan_devolutionDate");
        var state = _resultSet.getBoolean("state");

        return new Loan(
            loanID, 
            filmID, 
            clientID, 
            new Date(date.getTime()), 
            new Date(devolDate.getTime()), 
            state
            );
    }

    @Override
    protected List<Loan> resultSetToList(ResultSet _resultSet) throws SQLException {
        List<Loan> myLoans = new ArrayList<>();
        while (_resultSet.next() ) {
            myLoans.add(resultSetToEntity(_resultSet));
        }
        return myLoans;
    }

    
}
