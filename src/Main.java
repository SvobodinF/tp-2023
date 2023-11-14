import Data.IDatable;
import Data.InMemory;
import Models.Route;
import Models.Station;
import Models.Train;
import Services.RouteService;
import Utils.Coordinates;
import Utils.Time;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        IDatable storage = new InMemory();

        RouteService routeService = new RouteService(storage);

        LinkedList<Station> stations = new LinkedList<>();
        stations.add(new Station(new Coordinates(0,0),
                new Time(10,0,0),
                new Time(11,0,0)));
        stations.add(new Station(new Coordinates(1,2),
                new Time(11,10,0),
                new Time(12,0,0)));

        Route route = new Route("test", stations, new Train(145, 20));
    }
}