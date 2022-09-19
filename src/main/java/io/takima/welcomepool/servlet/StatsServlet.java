package io.takima.welcomepool.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/stats")
public class StatsServlet extends HttpServlet {


    public StatsServlet() {
        }

        public void init() {
            System.out.println("Servlet initialized successfully");
        }


        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/stats.jsp");
            dispatcher.forward(req, resp);

        }
    }
