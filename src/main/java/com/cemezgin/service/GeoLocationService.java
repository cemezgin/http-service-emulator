package com.cemezgin.service;

import com.cemezgin.model.City;

public class GeoLocationService {
    public static final String JSON = "json";
    public static final String XML = "xml";

    public String getTimezone(String countryCode, String type) {

        switch (countryCode) {
            case "07030":
                City antalya = new City("07", "Antalya", "GMT+3", "07030", "30C Sunny");
                return type.equals(XML) ? convertToXml(antalya) : convertToJson(antalya);
            case "10111":
                City tallinn = new City("TLL", "Tallinn", "GMT+2", "10111", "-10C Snowy");
                return type.equals(XML) ? convertToXml(tallinn) : convertToJson(tallinn);
            case "WC2N_5DU":
                City london = new City("LCY", "London", "GMT", "WC2N_5DU", "15C Rainy");
                return type.equals(XML) ? convertToXml(london) : convertToJson(london);
            default:
                return type.equals(XML) ? notFoundErrorXml() : notFoundErrorJson();
        }
    }

    private String convertToJson(City city) {
        return "{\"city\": [{\"timezone\":\"" + city.getTimezone() + "\"," +
                "\"name\":\"" + city.getName() + "\"}]}";
    }

    private String convertToXml(City city) {
        return "<city>" +
                "<weather>" + city.getTimezone() + "</weather>" +
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
