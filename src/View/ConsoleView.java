package View;

import Models.Route;
import Models.Station;
import ServiceLocator.Service;
import Services.RouteService;
import Utils.Time;

import java.util.List;

public class ConsoleView extends View implements Service {
    public ConsoleView(RouteService service) {
        routeService = service;
    }

    @Override
    public void getById(Long id) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n------" + "Получить маршрут с индексом " + id + "------\n");
        stringBuilder.append(routeService.getById(id).toString());
        stringBuilder.append("\n------" + "Получить маршрут с индексом " + id + "------");

        sendMessage(stringBuilder.toString());
    }

    @Override
    public void getAll() {
        List<Route> routes = routeService.getAll();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n------" + "Получить все маршруты" + "------");
        for (Route route: routes) {
            String routeName = route.getName();
            stringBuilder.append("\n------" + routeName + "------\n");
            stringBuilder.append(route).append("\n");
            stringBuilder.append("------" + routeName + "------\n");
        }
        stringBuilder.append("------" + "Получить все маршруты" + "------\n");

        sendMessage(stringBuilder.toString());
    }

    @Override
    public void getArriveTime(Long id) {
        StringBuilder stringBuilder = new StringBuilder();
        Route route = routeService.getById(id);
        Station station = route.getArriveStation();
        Time time = station.getArriveTime();

        stringBuilder.append("\n------" + "Получить время отправления у маршрута с индексом " + id + "------\n");
        stringBuilder.append("Маршрут: " + route.getName() + "\n" +
                "Время отправления: " + time.getHours() + ":" + time.getMinutes());
        stringBuilder.append("\n------" + "Получить время отправления у маршрута с индексом " + id + "------");

        sendMessage(stringBuilder.toString());
    }

    @Override
    public void getDepartureTime(Long id) {
        StringBuilder stringBuilder = new StringBuilder();
        Route route = routeService.getById(id);
        Station station = route.getDepartureStation();
        Time time = station.getArriveTime();

        stringBuilder.append("\n------" + "Получить время прибытия у маршрута с индексом " + id + "------\n");
        stringBuilder.append("Маршрут: " + route.getName() + "\n" +
                "Время прибытия: " + time.getHours() + ":" + time.getMinutes());
        stringBuilder.append("\n------" + "Получить время прибытия у маршрута с индексом " + id + "------");

        sendMessage(stringBuilder.toString());
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
