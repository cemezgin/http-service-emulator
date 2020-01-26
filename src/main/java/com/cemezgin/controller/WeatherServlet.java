package com.cemezgin.controller;

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
