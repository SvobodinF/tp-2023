package View;

import Models.Route;
import Services.RouteService;

import java.util.List;

public abstract class View {
    protected RouteService routeService;

    public abstract void getById(Long id);

    public abstract void getAll();

    public abstract void getArriveTime(Long id);
    public abstract void getDepartureTime(Long id);

    protected void sendMessage(String message){
        System.out.println(message);
    }
}
