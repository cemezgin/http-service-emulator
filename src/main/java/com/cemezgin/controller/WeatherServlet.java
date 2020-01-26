package com.cemezgin.controller;

import com.cemezgin.model.City;
import com.cemezgin.service.HttpService;
import com.cemezgin.service.WeatherService;

import java.io.IOException;

public class WeatherServlet extends javax.servlet.http.HttpServlet {

    private WeatherService weatherService;
    private HttpService httpService;

    @Override
    public void init() throws javax.servlet.ServletException {
        this.weatherService = new WeatherService();
        this.httpService = new HttpService();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
           String countryCode = request.getParameter("countryCode");
           String weather = null;

           if (countryCode != null) {
               weather = this.weatherService.getWeather(countryCode);
           }

           this.httpService.getJsonResponse(response, weather);
    }
}
