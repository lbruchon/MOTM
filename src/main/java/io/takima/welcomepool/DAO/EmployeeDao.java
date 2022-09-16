package io.takima.welcomepool.DAO;


import io.takima.welcomepool.model.Employee;

import javax.resource.spi.ConnectionManager;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeDao {


    public EmployeeDao() {
    }

    private static final String CREATE_EMPLOYEE_QUERY = "INSERT INTO employee(name, email, birthdate) VALUES(?, ?, ?);";

    public long create(Employee employee) {

        long up = 0;

        try
        {
        //étape 1: charger la classe de driver

            Class.forName("org.postgresql.Driver");

        //étape 2: créer l'objet de connexion
        //Connection conn = DriverManager.getConnection(
                //"jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
        //étape 3: créer l'objet statement

            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
                PreparedStatement pstmt = conn.prepareStatement(CREATE_EMPLOYEE_QUERY);

            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getEmail());
            pstmt.setString(3, employee.getBirthdate());


            up = pstmt.executeUpdate();


            return up;

            /*
        Statement stmt = conn.createStatement();

        ResultSet res = stmt.executeQuery(CREATE_EMPLOYEE_QUERY);

        conn.close();*/
        }
        catch(Exception e){
            System.out.println(e);
        }

        return 0;
    }


}


