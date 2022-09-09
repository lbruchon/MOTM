package io.takima.welcomepool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet{
    static String PAGE_HEADER = "<html><head><title>helloworld</title></head><body>";
    static String PAGE_FOOTER = "</body></html>";
    HomeService helloService = new HomeService();

    public HomeServlet() {
    }

    public void init() {
        System.out.println("Servlet initialized successfully");
    }

    protected void doGet(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        var2.setContentType("text/html");
        PrintWriter var3 = var2.getWriter();
        var3.println(PAGE_HEADER);
        //var3.println("<h1>" + this.helloService.createHelloMessage("World") + "</h1>");
        var3.println(PAGE_FOOTER);
        var3.close();
    }
}

