package Repository.Samples.Database;

import Models.Datable;
import Models.Route;
import Models.Train;
import Repository.Repositoreble;
import Repository.Samples.InMemory.Storage;
import Services.RouteService;
import View.ConsoleView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DatabaseRepository<T extends Datable> implements Repositoreble<T> {

    private ConnectionManager connection;

    public DatabaseRepository(ConnectionManager manager)
    {
        this.connection = manager;
    }
    @Override
    public T get(Long id) {
        try (Statement statement = connection.getStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from Routes where id = " + id);

            Dictionary<String, Object> result = new Hashtable<>();
            while (resultSet.next()) {
                long uid = resultSet.getLong("id");
                String name = resultSet.getString("name");

                result.put("id", uid);
                result.put("name", name);

                ResultSet trainsSet = statement.executeQuery("select * from Trains where route = " + id);
                int number = trainsSet.getInt("number");
                int speed = trainsSet.getInt("speed");

                Train train = new Train(number, speed);
                result.put("train", train);
            }

            Route route = new Route();
            route.construct(result);
            return (T)route;
        } catch (SQLException e) {
            throw new RuntimeException("Error while statement executing");
        }
    }

    @Override
    public List<T> getAll() {
        try (Statement statement = connection.getStatement()) {
            ResultSet resultSet =
                    statement.executeQuery("select * from Routes");
            List<T> result = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getInt("id");
                result.add(get(id));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Error while statement executing");
        }
    }

    @Override
    public void add(T obj) throws SQLException {
        connection.getStatement().execute("INSERT INTO Routes " + obj.getData());
    }

    @Override
    public void remove(T obj) throws SQLException {
        connection.getStatement().execute("DELETE FROM Routes " +
                "WHERE" + obj.getId());
    }

    @Override
    public void edit(T obj) throws SQLException {
        connection.getStatement().execute("UPDATE Routes SET" + obj.getData() +
                "WHERE" + obj.getId());
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
