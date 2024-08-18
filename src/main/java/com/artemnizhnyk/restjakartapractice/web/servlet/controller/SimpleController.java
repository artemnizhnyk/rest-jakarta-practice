package com.artemnizhnyk.restjakartapractice.web.servlet.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/"})
public class SimpleController extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("<h1>");
            printWriter.println("Hello from SimpleController servlet");
            printWriter.println("</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
