package io.takima.welcomepool;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@SuppressWarnings("serial")
@WebServlet(name = "controller", urlPatterns = {"/home", "/addmember"})

public class Controller extends HttpServlet {
    HomeService homeservice = new HomeService();
    AddMemberService addmemberservice = new AddMemberService();

    @Override
    public void init() {
        System.out.println("Servlet initialized successfully");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userPath = req.getServletPath();

        // if category page is requested
        if (userPath.equals("/home")) {
            req.setAttribute("homeService", this.homeservice);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);

        } else if (userPath.equals("/addmember")) {
            req.setAttribute("addMember", this.addmemberservice);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/add_member.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
