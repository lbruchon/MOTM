package io.takima.welcomepool;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addmember")
public class AddMemberServlet extends HttpServlet{

    AddMemberService addmemberservice = new AddMemberService();

    public AddMemberServlet() {
    }

    public void init() {
        System.out.println("Servlet initialized successfully");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            req.setAttribute("addMember", addmemberservice);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/add_member.jsp");
            dispatcher.forward(req, resp);

    }
}
