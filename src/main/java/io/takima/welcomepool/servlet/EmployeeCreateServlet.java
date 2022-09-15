package io.takima.welcomepool.servlet;

import io.takima.welcomepool.exception.ServiceException;
import io.takima.welcomepool.model.Employee;
import io.takima.welcomepool.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/add_member.jsp")
public class EmployeeCreateServlet extends HttpServlet {
    EmployeeService employeeService;

    @Override
    public void init() {
        System.out.println("Servlet initialized successfully");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        // TODO

        request.getRequestDispatcher("../WEB-INF/pages/add_member.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Employee employee = new Employee(0, request.getParameter("name"),request.getParameter("email"), LocalDate.parse(request.getParameter("birthdate")));
        try {
            employeeService.create(employee);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        doGet(request, response);
    }
}
