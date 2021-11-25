package tec.bases;

import com.zaxxer.hikari.HikariDataSource;

import tec.bases.dao.CategoryDAO;
import tec.bases.dao.LoanDAO;
import tec.bases.dao.daoImplementation.CategoryDAOimplementation;
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
        CategoryDAO mySQLCat = initCategoryDao(hikariDataSource);

        this.blockbuster = initBlockBuster(mySQLloans, mySQLCat);
    }

    private static HikariDataSource initHikariDataSource() {
        HikariConfig config = new HikariConfig("/database.properties");
        return new HikariDataSource(config);
    }

    private static LoanDAO initLoanDao(DataSource dataSource) {
        return new LoanDAOimplementation(dataSource);
    }

    private static CategoryDAO initCategoryDao(DataSource dataSource) {
        return new CategoryDAOimplementation(dataSource);
    }

    private static Blockbuster initBlockBuster(LoanDAO _loanDao, CategoryDAO _catDao) {
        return new Blockbuster(_loanDao, _catDao);
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
