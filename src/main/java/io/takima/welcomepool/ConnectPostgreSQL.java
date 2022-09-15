package io.takima.welcomepool;

import java.sql.*;
public class ConnectPostgreSQL
{
    public static void main(String args[])
    {
        try
        {
            //étape 1: charger la classe de driver
            Class.forName("org.postgresql.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres","anat","new_password");
            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM employee");
            //ResultSet res = stmt.executeQuery("INSERT INTO employee(name, email, birthdate) VALUES('jean', 'jean@', '11/11/1911')");
            //ResultSet res = stmt.executeQuery("DELETE FROM employee");
            //étape 4: exécuter la requête
            while(res.next())
                System.out.println(res.getInt(1)+"  "+res.getString(2)
                        +"  "+res.getString(3)+"  "+res.getString(4));
            //étape 5: fermez l'objet de connexion
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}