package Services;

import Models.Route;
import Repository.Repositoreble;
import ServiceLocator.Service;

import java.util.List;

public class RouteService implements Service {
    private final Repositoreble<Route> repositoreble;

    public RouteService(Repositoreble<Route> repositoreble) {
        this.repositoreble = repositoreble;
    }

    public Route getById(Long id) {
        return repositoreble.get(id);
    }

    public List<Route> getAll() {
        return repositoreble.getAll();
    }

    public void add(Route route) {
        repositoreble.add(route);
    }

    public void remove(Route route) {
        repositoreble.remove(route);
    }

    @Override
    public String getName() {
        return getClass().getName();
    }
}
