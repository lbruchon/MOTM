package io.takima.welcomepool.servlet;

import io.takima.welcomepool.DAO.EmployeeDao;
import io.takima.welcomepool.model.Employee;
import io.takima.welcomepool.service.EmployeeService;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{

    EmployeeDao emp = new EmployeeDao();
    EmployeeService employeeservice = new EmployeeService();

    public HomeServlet() {
    }

    public void init() {
        System.out.println("Servlet initialized successfully");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            ArrayList<Employee> employeList = (ArrayList<Employee>) employeeservice.findAll();

            req.setAttribute("employees", employeList);
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Employee employe = new Employee(Integer.parseInt(request.getParameter("uuid")), ""  ,"" ,"" );
        try {

            employeeservice.delete(employe);


        } catch (ServiceException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        doGet(request, response);
    }
}

