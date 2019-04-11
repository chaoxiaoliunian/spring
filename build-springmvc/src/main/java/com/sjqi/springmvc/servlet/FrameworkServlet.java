package com.sjqi.springmvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 顶级servlet，专门用于被继承的
 */
public class FrameworkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDispatcher(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doDispatcher(request, response);
    }

    public void doDispatcher(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }
}
