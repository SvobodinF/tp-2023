package ServiceLocator;

import Models.Route;
import Repository.Repositoreble;
import Repository.Samples.Database.ConnectionManager;
import Repository.Samples.Database.DatabaseRepository;
import Repository.Samples.InMemory.InMemoryRepository;
import Repository.Samples.InMemory.Storage;
import Services.RouteService;
import View.ConsoleView;

public class ServiceLocator {
    private static final Cache cache;

    static {
        cache = new Cache();

        initialContext();
    }

    private static void initialContext(){
        Storage<Route> storage = new Storage<>();
        //Repositoreble<Route> repositoreble = new InMemoryRepository<Route>(storage);
        Repositoreble<Route> repositoreble = new DatabaseRepository(new ConnectionManager());

        cache.addService(new RouteService(repositoreble));
        cache.addService(new ConsoleView(getService(RouteService.class)));
    }

    public static<T> T getService(Class classInstance)
    {
        Service service = cache.getService(classInstance.getName());

        if (service != null) {
            return (T)service;
        }

        throw new NullPointerException("Service is not initialized");
    }
}