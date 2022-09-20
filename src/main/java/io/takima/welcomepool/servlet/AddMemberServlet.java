package io.takima.welcomepool.servlet;

import io.takima.welcomepool.DAO.EmployeeDao;
import io.takima.welcomepool.model.Employee;
import io.takima.welcomepool.service.EmployeeService;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

@WebServlet("/addmember")
public class AddMemberServlet extends HttpServlet{


    EmployeeDao emp = new EmployeeDao();
    EmployeeService employeeservice = new EmployeeService();
    public AddMemberServlet() {
    }

    public void init() {

        System.out.println("Servlet initialized successfully");

    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/add_member.jsp");
            dispatcher.forward(req, resp);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("name" + request.getParameter("name"));

        Employee employee = new Employee( 0, request.getParameter("name"),request.getParameter("email"), request.getParameter("date"));

        employeeservice.create(employee);
        doGet(request, response);
    }


}
