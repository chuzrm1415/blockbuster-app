package tec.bases;

import com.zaxxer.hikari.HikariDataSource;

import tec.bases.dao.LoanDAO;
import tec.bases.dao.daoImplementation.LoanDAOimplementation;
import tec.bases.entity.Loan;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;


public class ApplicationContext {

    private Blockbuster blockbuster;


    public ApplicationContext() {
        var hikariDataSource = initHikariDataSource();
        LoanDAO mySQLloans = initLoanDao(hikariDataSource);

        this.blockbuster = initBlockBuster(mySQLloans);
    }

    private static HikariDataSource initHikariDataSource() {
        HikariConfig config = new HikariConfig("/database.properties");
        return new HikariDataSource(config);
    }

    private static LoanDAO initLoanDao(DataSource dataSource) {
        return new LoanDAOimplementation(dataSource);
    }

    private static Blockbuster initBlockBuster(LoanDAO _loanDao) {
        return new Blockbuster(_loanDao);
    }

    public List<Loan> getLoans() throws SQLException {
        return this.blockbuster.getAllLoans();
    }
    

    /**
     * @return Blockbuster return the blockbuster
     */
    public Blockbuster getBlockbuster() {
        return blockbuster;
    }

    /**
     * @param blockbuster the blockbuster to set
     */
    public void setBlockbuster(Blockbuster blockbuster) {
        this.blockbuster = blockbuster;
    }

}
