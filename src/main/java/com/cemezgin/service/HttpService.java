package com.cemezgin.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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

    public String extractPostRequestBody(javax.servlet.http.HttpServletRequest request) throws IOException {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            Scanner s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
            return s.hasNext() ? s.next() : "";
        }
        return "";
    }
}
