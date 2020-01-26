package com.cemezgin.service;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;

public class HttpService {
    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String CONTENT_TYPE_XML = "application/xml";

    public void getJsonResponse(javax.servlet.http.HttpServletResponse response, String parameter) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType(CONTENT_TYPE_JSON);
        response.setCharacterEncoding("UTF-8");
        out.println(parameter);
        out.flush();
        out.close();
    }

    public void getXmlResponse(javax.servlet.http.HttpServletResponse response, String parameter) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType(CONTENT_TYPE_XML);
        response.setCharacterEncoding("UTF-8");
        out.println(parameter);
        out.flush();
        out.close();
    }


    private String parseToJson(String str) {
        Gson g = new Gson();
        return g.toJson(str);
    }
}
