package Repository;

import ServiceLocator.Service;

import java.sql.SQLException;
import java.util.List;

public interface Repositoreble<T> extends Service {
    T get(Long id);

    List<T> getAll();


    void add(T obj) throws SQLException;

    void remove(T obj) throws SQLException;
    void edit(T obj) throws SQLException;
}
