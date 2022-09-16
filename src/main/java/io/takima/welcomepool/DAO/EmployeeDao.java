package io.takima.welcomepool.DAO;


import io.takima.welcomepool.model.Employee;

import java.sql.*;

public class EmployeeDao {

    private static final String CREATE_EMPLOYEE_QUERY = "INSERT INTO Employee(name, email, birthdate) VALUES(?, ?, ?);";

    public long create(Employee employee) {

        try
        {
        //étape 1: charger la classe de driver
        Class.forName("org.postgresql.Driver");
        //étape 2: créer l'objet de connexion
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres","anat","new_password");
        //étape 3: créer l'objet statement
        Statement stmt = conn.createStatement();

        ResultSet res = stmt.executeQuery(CREATE_EMPLOYEE_QUERY);

        conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

        return 0;
    }


}


