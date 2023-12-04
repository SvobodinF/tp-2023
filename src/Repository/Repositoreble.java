package Repository;

import ServiceLocator.Service;

import java.util.List;

public interface Repositoreble<T> extends Service {
    T get(Long id);

    List<T> getAll();

    void add(T obj);

    void remove(T obj);
    void edit(T obj);
}
