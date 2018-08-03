package server;

import com.company.WeatherService;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    private static final int PORT = 1099;
    private static Registry registry;

    public static void startRegistry() throws RemoteException{

        //creating server registry
        registry = LocateRegistry.createRegistry(PORT);
    }

    public static void registerObject(String name, Remote remoteObj)
                    throws RemoteException, AlreadyBoundException{

        //bind object in registry with certain name
        //client will lookup on the registration of the name to get object
        registry.bind(name, remoteObj);
        System.out.println("Registered: "+ name + " -> " + remoteObj.getClass().getName()
                            + "["+ remoteObj + "]");

    }

    public static void main(String[] args) throws Exception{
        System.out.println("Server starting...");
        startRegistry();
        registerObject(WeatherService.class.getSimpleName(), new WeatherServiceImpl());


        // server started and listening to the request from the client
        System.out.println("Server started!");

    }
}
