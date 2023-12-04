import Models.Route;
import Models.Station;
import Models.Train;
import Services.RouteService;
import ServiceLocator.*;
import Utils.Coordinates;
import Utils.Time;
import View.*;

import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        RouteService routeService = ServiceLocator.getService(RouteService.class);
        View view = ServiceLocator.getService(ConsoleView.class);

        //Добавить новый маршрут
        routeService.add(new Route("Маршрут 1", new Train(10, 50), 1L));
        routeService.add(new Route("Маршрут 2", new Train(11, 60), 2L));

        //Добавить добавить станции в маршрут
        Route route1 = routeService.getById(1L);
        route1.AddStation(new Station(new Coordinates(1,2),
                new Time(10,0), new Time(0,15)));
        route1.AddStation(new Station(new Coordinates(4,6)));
        route1.AddStation(new Station(new Coordinates(8,11)));

        Route route2 = routeService.getById(2L);
        route2.AddStation(new Station(new Coordinates(11,55),
                new Time(21,0), new Time(0,15)));
        route2.AddStation(new Station(new Coordinates(4,6)));


        view.getAll();
        view.getById(2l);

        view.getArriveTime(1L);
        view.getDepartureTime(1L);

        view.getArriveTime(2L);
        view.getDepartureTime(2L);
    }
}