package com.cemezgin.controller;

import com.cemezgin.model.City;
import com.cemezgin.service.GeoLocationService;
import com.cemezgin.service.HttpService;
import com.cemezgin.service.WeatherService;
import com.google.gson.Gson;

import java.io.IOException;

public class HttpServlet extends javax.servlet.http.HttpServlet {

    private WeatherService weatherService;
    private HttpService httpService;
    private GeoLocationService locationService;

    @Override
    public void init() throws javax.servlet.ServletException {
        this.weatherService = new WeatherService();
        this.httpService = new HttpService();
        this.locationService = new GeoLocationService();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String requestBody = this.httpService.extractPostRequestBody(request);

        Gson gson = new Gson();
        City city = gson.fromJson(requestBody, City.class);
        String zipCode = city.getZip();
        city.setIsXml(city.isXml);
        boolean isXml = city.getIsXml();

        String timezone = null;

        if (zipCode != null) {
            if (isXml) {
                timezone = this.locationService.getTimezone(zipCode, GeoLocationService.XML);
            } else {
                timezone = this.locationService.getTimezone(zipCode, GeoLocationService.JSON);
            }
        }

        if (isXml) {
            this.httpService.getXmlResponse(response, timezone);
        } else {
            this.httpService.getJsonResponse(response, timezone);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String countryCode = request.getParameter("countryCode");
        String isXml = request.getParameter("xml") != null ? request.getParameter("xml") : "0";
        String weather = null;

        if (countryCode != null) {
            if (isXml.equals("1")) {
                weather = this.weatherService.getWeather(countryCode, WeatherService.XML);
            } else {
                weather = this.weatherService.getWeather(countryCode, WeatherService.JSON);
            }
        }

        if (isXml.equals("1")) {
            this.httpService.getXmlResponse(response, weather);
        } else {
            this.httpService.getJsonResponse(response, weather);
        }
    }
}
