import Models.Route;
import Repository.Repositoreble;
import Repository.Samples.InMemory.InMemoryRepository;
import Repository.Samples.InMemory.Storage;
import Services.RouteService;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Storage<Route> storage = new Storage<>();
        Repositoreble<Route> repositoreble = new InMemoryRepository(storage);
        RouteService routeService = new RouteService(repositoreble);
    }
}