package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface WeatherService extends Remote{

    //method for retrieve weather info
    public WeatherData getWeather(Date date, String location)
                        throws RemoteException;
}
