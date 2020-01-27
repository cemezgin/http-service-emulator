package com.cemezgin.model;

public class City {
    private String code;
    private String timezone;
    private String zip;
    private String name;
    private String weather;
    public boolean isXml;

    public City(String code, String name, String timezone, String zip, String weather) {
        this.code = code;
        this.timezone = timezone;
        this.name = name;
        this.zip = zip;
        this.weather = weather;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    public boolean getIsXml() {
        return isXml;
    }

    public void setIsXml(boolean isXml) {
        this.isXml = isXml;
    }
}

