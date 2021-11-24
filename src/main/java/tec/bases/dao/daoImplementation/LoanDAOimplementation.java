package tec.bases.dao.daoImplementation;

import tec.bases.entity.Loan;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import tec.bases.dao.LoanDAO;

public class LoanDAOimplementation extends GenericDAOimplementation<Loan, Long> implements LoanDAO {

    private final DataSource dataSource;

    // Loans Querrys
    private static final String FIND_ALL_LOAN_PROC = "{CALL show_loans}";
    private static final String INSERT_LOAN = "{CALL create_loan(?, ?, ?)}";
    private static final String FIND_LOAN_BY_ID = "{CALL find_loansByFilm(?)}";


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
    public Optional<Loan> findByID(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Loan> findByFilm(Long filmID) throws SQLException {
        Connection dbConnection = getDBconnection();
        dbConnection.setAutoCommit(false);

        try (CallableStatement callStat = dbConnection.prepareCall(FIND_LOAN_BY_ID)) {
            callStat.setLong(1, filmID);
            var resultSet = callStat.executeQuery();
            if (resultSet.next()) {
                //resultSet.first();
                //var temp = resultSetToList(resultSet);
                //System.out.println(temp.size());
                return resultSetToList(resultSet);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
        }
        return Collections.emptyList();
    }

    
    @Override
    public void save(Loan t) throws SQLException  {
        Connection dbConnection = getDBconnection();
        dbConnection.setAutoCommit(false);

        try (CallableStatement callStat = dbConnection.prepareCall(INSERT_LOAN) ) {
            callStat.setLong(1, t.getFilmID());
            callStat.setLong(2, t.getClientID());
            callStat.setDate(3, (Date) t.getLoanDate());
            callStat.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
        }
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
        var loanID = _resultSet.getLong("loan_ID");
        var filmID = _resultSet.getLong("loan_filmID");
        var clientID = _resultSet.getLong("loan_clientID");
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
