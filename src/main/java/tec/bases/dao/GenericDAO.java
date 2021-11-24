package tec.bases.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, ID extends Serializable> {

    List<T> findAll() throws SQLException;

    Optional<T> findByID(ID id) throws SQLException;

    void save(T t) throws SQLException;

    Optional<T> update(T t) throws SQLException;

    void delete(ID id) throws SQLException;

}
