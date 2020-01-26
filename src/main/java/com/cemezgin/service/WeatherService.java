package com.cemezgin.service;

import com.cemezgin.model.City;

public class WeatherService {

    public static final String JSON = "json";
    public static final String XML = "xml";

    public String getWeather(String countryCode, String type) {

        switch (countryCode) {
            case "07":
                City antalya = new City("07", "Antalya", "GMT+3", "O7030", "30C Sunny");
                return type.equals(XML) ? convertToXml(antalya) : convertToJson(antalya);
            case "TLL":
                City tallinn = new City("TLL", "Tallinn", "GMT+2", "10111", "-10C Snowy");
                return type.equals(XML) ? convertToXml(tallinn) : convertToJson(tallinn);
            case "LCY":
                City london = new City("LCY", "London", "GMT", "WC2N_5DU", "15C Rainy");
                return type.equals(XML) ? convertToXml(london) : convertToJson(london);
            default:
                return type.equals(XML) ? notFoundErrorXml() : notFoundErrorJson();
        }
    }

    private String convertToJson(City city) {
        return "{\"city\": [{\"weather\":\"" + city.getWeather() + "\"," +
                "\"name\":\"" + city.getName() + "\"}]}";
    }

    private String convertToXml(City city) {
        return "<city>" +
                "<weather>" + city.getWeather() + "</weather>" +
                "<name>" + city.getName() + "</name>" +
                "</city>";

    }

    private String notFoundErrorJson() {
        return "[{\"error\":\"City not found.\"," +
                "\"code\":\"404\"}]";
    }

    private String notFoundErrorXml() {
        return "<error>City not found.</error>";
    }
}
