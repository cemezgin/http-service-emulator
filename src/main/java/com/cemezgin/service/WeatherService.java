package com.cemezgin.service;

import com.cemezgin.model.City;

public class WeatherService {
    public String getWeather(String countryCode) {
        switch (countryCode) {
            case "07" :
                City antalya = new City("07","Antalya","GMT+3","O7030", "30" );
                return antalya.getWeather();
            case "TLL":
                City tallinn = new City("TLL","Tallinn","GMT+2","10111", "-10" );
                return tallinn.getWeather();
            case "LCY":
                City london = new City("LCY","London","GMT","WC2N_5DU", "-10" );
                return london.getWeather();
            default:
                return "City not found.";
        }
    }
}
