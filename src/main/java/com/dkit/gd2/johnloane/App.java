package com.dkit.gd2.johnloane;

import java.util.Collection;
import java.util.Set;

/**
 * CA5 Final Exam
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "CA5 Final Exam");


        City dublin = new City("Dublin");
        City galway = new City("Galway");
        City monaghan = new City("Monaghan");

        dublin.connect(galway);

        System.out.println(dublin.isConnected(galway));
        System.out.println(galway.isConnected(dublin));
        System.out.println(monaghan.isConnected(dublin));

        Set<City> dublinConnections = dublin.getConnections();
        for(City c : dublinConnections)
        {
            System.out.println("City : " + c.name);
        }
        dublin.connect(monaghan);
        dublinConnections = dublin.getConnections();
        for(City c : dublinConnections)
        {
            System.out.println("City : " + c.name);
        }
    }
}
