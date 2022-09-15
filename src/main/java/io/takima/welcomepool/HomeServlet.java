package io.takima.welcomepool;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet{

    HomeService helloService = new HomeService();

    public HomeServlet() {
    }

    public void init() {
        System.out.println("Servlet initialized successfully");
    }

    protected void doGet(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {

    }
}

