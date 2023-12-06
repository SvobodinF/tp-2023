package Repository.Samples.Database;

import Models.Datable;
import Models.Route;
import Repository.Repositoreble;
import Repository.Samples.InMemory.Storage;
import Services.RouteService;
import View.ConsoleView;

import java.sql.SQLException;
import java.util.List;

public class DatabaseRepository<T extends Datable> implements Repositoreble<T> {

    private ConnectionManager connection;

    public DatabaseRepository(ConnectionManager manager)
    {
        this.connection = manager;
    }
    @Override
    public T get(Long id) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public void add(T obj) {

    }

    @Override
    public void remove(T obj) {

    }

    @Override
    public void edit(T obj) {

    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
