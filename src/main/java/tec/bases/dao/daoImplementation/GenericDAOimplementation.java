package tec.bases.dao.daoImplementation;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import tec.bases.dao.GenericDAO;


public abstract class GenericDAOimplementation<T, ID extends Serializable> implements GenericDAO<T, ID> {

    protected abstract T resultSetToEntity(ResultSet _resultSet) throws SQLException;

    //protected abstract Optional<T> uniqueResultSetToEntity(ResultSet _ResultSet) throws SQLException;

    protected abstract List<T> resultSetToList(ResultSet _resultSet) throws SQLException;
    
}
