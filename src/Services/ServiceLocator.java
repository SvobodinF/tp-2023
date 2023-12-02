package Services;

import com.sun.jdi.InterfaceType;

import java.util.Hashtable;

public class ServiceLocator {
    private static ServiceLocator instance;

    public ServiceLocator GetInstance(){
        if (instance == null)
            instance = new ServiceLocator();

        return  instance;
    }
    private Hashtable<Object, Class> services;

    public <T> void Put(T instance){

    }
}
