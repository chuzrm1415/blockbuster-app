package tec.bases.dao.daoImplementation;

import tec.bases.entity.Loan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;
import tec.bases.dao.LoanDAO;

public class LoanDAOimplementation extends GenericDAOimplementation<Loan, Long> implements LoanDAO {

    private final DataSource dataSource;

    // Loans Querrys
    private static final String FIND_ALL_LOAN_PROC = "{CALL show_loans}";


    public LoanDAOimplementation(DataSource _dataSource) {
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
    public List<Loan> findAll() throws SQLException {
        List<Loan> myLoans = new ArrayList<>();
        Connection dbConnection = getDBconnection();
        dbConnection.setAutoCommit(false);
        
        try (java.sql.CallableStatement callStat = dbConnection.prepareCall(FIND_ALL_LOAN_PROC) ) {
            var resultSet = callStat.executeQuery();
            return resultSetToList(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
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
            date, 
            devolDate, 
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
