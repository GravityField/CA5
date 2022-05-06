package com.dkit.gd2.johnloane;


import java.util.*;

public class City
{
    public String name;
    //Add appropriate collection to store connections here
//    Map<City, City[]> map = new HashMap<>();
    Set<City> city = new HashSet<>();

    //Complete
    public City(String name)
    {
        this.name = name;
        //Set up collection added above
        Set<City> city = new HashSet<>();
    }

    //Complete
    public void connect(City city)
    {
        this.city.add(city);
        city.city.add(this);
    }

    //Uncomment and complete
    public Set<City> getConnections()
    {
        Set<City> connections = this.city;
        return connections;
    }

    //Uncommment and complete
    public boolean isConnected(City city)
    {
        if(this.city.contains(city))
        {
            return true;
        }
        else
        {
            return false;
        }
    }


}
