package com.dkit.gd2.johnloane;

import java.util.ArrayList;

public class Country
{
    private String countryName;
    private ArrayList listOfCounties;

    public Country(String countryName, ArrayList listOfCounties)
    {
        this.countryName = countryName;
        this.listOfCounties = new ArrayList();
        this.listOfCounties = listOfCounties;
    }

    public String getCountryName()
    {
        return countryName;
    }

    public ArrayList getListOfCounties()
    {
        return listOfCounties;
    }
}
