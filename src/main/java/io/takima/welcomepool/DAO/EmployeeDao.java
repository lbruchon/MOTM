package io.takima.welcomepool.DAO;


import io.takima.welcomepool.model.Employee;

import javax.resource.spi.ConnectionManager;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {


    public EmployeeDao() {
    }

    private static final String CREATE_EMPLOYEE_QUERY = "INSERT INTO employee(name, email, birthdate) VALUES(?, ?, ?);";
    private static final String FIND_EMPLOYEE_QUERY = "SELECT uuid, name, email, birthdate FROM employee;";
    private static final String DELETE_EMPLOYEE_QUERY = "DELETE FROM employee WHERE uuid=?;";

    public long create(Employee employee) {

        long up = 0;

        try
        {

            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
                PreparedStatement pstmt = conn.prepareStatement(CREATE_EMPLOYEE_QUERY);

            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getEmail());
            pstmt.setString(3, employee.getBirthdate());

            up = pstmt.executeUpdate();


            return up;

        }
        catch(Exception e){
            System.out.println(e);
        }

        return 0;
    }


    public List<Employee> findAll(){

        long up = 0;

        List<Employee> clientList = new ArrayList<>();


        try {

            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            PreparedStatement pstmt = conn.prepareStatement(FIND_EMPLOYEE_QUERY);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                int employeeId = rs.getInt("uuid");
                String employeeName = rs.getString("name");
                String employeeEmail = rs.getString("email");
                String employeeBirthdate = rs.getString("birthdate");


                Employee employee = new Employee(
                        employeeId, employeeName,employeeEmail, employeeBirthdate );
                clientList.add(employee);
            }

        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return clientList;
    }

    public long delete(Employee employee) throws ClassNotFoundException {
        long up = 0;

        try{

            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            PreparedStatement pstmt = conn.prepareStatement(DELETE_EMPLOYEE_QUERY);

            pstmt.setInt(1, employee.getUuid());
            up = pstmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return up;

    }

}


