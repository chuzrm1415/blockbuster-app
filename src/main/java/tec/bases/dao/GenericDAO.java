package tec.bases.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, ID extends Serializable> {

    List<T> findAll();

    Optional<T> findByID(ID id);

    void save(T t);

    Optional<T> update(T t);

    void delete(ID id);

}
