package client;

import com.company.Constants;
import com.company.WeatherData;
import com.company.WeatherService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class Client {

    //host/ip of server
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static Registry registry;

    public static void main(String[] args) throws Exception{

        //search the registry in the specific host and port
        registry = LocateRegistry.getRegistry(HOST, PORT);

        //lookup WeatherService in the registry
        WeatherService service = (WeatherService) registry
                .lookup(WeatherService.class.getSimpleName());

        Date today = new Date();

        //getting New-York weather info:
        WeatherData new_yorkWeather = service.getWeather(today, Constants.LOCATION_NEW_YORK);
        System.out.println("New-York weather today: "+ new_yorkWeather.getWeather());

        //getting London weather info:
        WeatherData londonWeather = service.getWeather(today, Constants.LOCATION_LONDON);
        System.out.println("London weather today: "+londonWeather.getWeather());

        //getting Paris weather info:
        WeatherData parisWeather = service.getWeather(today, Constants.LOCATION_PARIS);
        System.out.println("Paris weather today: "+parisWeather.getWeather());
    }
}
