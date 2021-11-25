package tec.bases.dao.daoImplementation;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import tec.bases.dao.CategoryDAO;
import tec.bases.entity.Category;

public class CategoryDAOimplementation extends GenericDAOimplementation<Category, Long> implements CategoryDAO {

    private final DataSource dataSource;

    // Category Querrys
    private static final String INSERT_CATEGORY = "{CALL create_category(?)}";
    private static final String FIND_ALL_CATEGORYS = "{CALL show_categorys}";
    private static final String FIND_CATEGORY_BY_ID = "{CALL find_categoryById(?)}";
    private static final String DELETE_CATEGORY = "{CALL delete_categoryById(?)}";
    private static final String UPDATE_CATEGORY = "{CALL update_categoryById(?, ?)}";




    public CategoryDAOimplementation(DataSource _dataSource) {
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





    //Methods...
    @Override
    public List<Category> findAll() throws SQLException {
        List<Category> myCategorys = new ArrayList<>();
        Connection dbConnection = getDBconnection();
        dbConnection.setAutoCommit(false);
        
        try (java.sql.CallableStatement callStat = dbConnection.prepareCall(FIND_ALL_CATEGORYS) ) {
            var resultSet = callStat.executeQuery();
            return resultSetToList(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
        }
        return myCategorys;
    }

    @Override
    public Optional<Category> findByID(Long id) throws SQLException {
        Connection dbConnection = getDBconnection();
        dbConnection.setAutoCommit(false);

        try (CallableStatement callStat = dbConnection.prepareCall(FIND_CATEGORY_BY_ID)) {
            callStat.setLong(1, id);
            var resultSet = callStat.executeQuery();
            resultSet.next();
            return Optional.ofNullable(resultSetToEntity(resultSet));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
        }
        return Optional.empty();
    }

    @Override
    public void save(Category t) throws SQLException {
        Connection dbConnection = getDBconnection();
        dbConnection.setAutoCommit(false);

        try (CallableStatement callStat = dbConnection.prepareCall(INSERT_CATEGORY)) {
            callStat.setString(1, t.getCatDescription());
            callStat.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
        }
    }

    @Override
    public void update(Category t) throws SQLException {
        Connection dbConnection = getDBconnection();
        dbConnection.setAutoCommit(false);

        try (CallableStatement callStat = dbConnection.prepareCall(UPDATE_CATEGORY)) {
            callStat.setLong(1, t.getCatID());
            callStat.setString(2, t.getCatDescription());
            callStat.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection dbConnection = getDBconnection();
        dbConnection.setAutoCommit(false);

        try (CallableStatement callStat = dbConnection.prepareCall(DELETE_CATEGORY)) {
            callStat.setLong(1, id);
            callStat.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dbConnection.rollback();
        }
    }

    @Override
    protected Category resultSetToEntity(ResultSet _resultSet) throws SQLException {
        var catID = _resultSet.getLong("cat_ID");
        var descrip = _resultSet.getString("cat_descrip");
        return new Category(catID, descrip);
    }

    @Override
    protected List<Category> resultSetToList(ResultSet _resultSet) throws SQLException {
        List<Category> myCategorys = new ArrayList<>();
        while (_resultSet.next() ) {
            myCategorys.add(resultSetToEntity(_resultSet));
        }
        return myCategorys;
    }  
}
