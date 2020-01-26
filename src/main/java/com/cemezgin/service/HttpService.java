package com.cemezgin.service;

import java.io.IOException;
import java.io.PrintWriter;

public class HttpService {
    public void getJsonResponse(javax.servlet.http.HttpServletResponse response, String parameter) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(parameter);
        out.flush();
        out.close();
    }
}
