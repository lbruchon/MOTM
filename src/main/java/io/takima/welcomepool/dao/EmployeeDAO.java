package io.takima.welcomepool.dao;

import io.takima.welcomepool.exception.DaoException;
import io.takima.welcomepool.model.Employee;

import java.sql.*;

public class EmployeeDAO {

    String url = "jdbc:postgresql://localhost:5432/testdb";
    String user = "user12";
    String password = "34klq*";

    private static final String CREATE_EMPLOYEE = "INSERT INTO Employee(name, email, birthdate) VALUES(?, ?, ?);";
    private static final String UPDATE_EMPLOYEE = "UPDATE Employee SET name=?, email=?, birthdate=? WHERE id=?;";

    public long create(Employee employee) throws DaoException {

        long numberOfInsertedRows = 0;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_EMPLOYEE);) {
                preparedStatement.setString(1, employee.getEmployeeName());
                preparedStatement.setString(2, employee.getEmployeeEmail());
                preparedStatement.setString(3, employee.getEmployeeBirthdate().toString());

                numberOfInsertedRows = preparedStatement.executeUpdate();

            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            return numberOfInsertedRows;
        }

    public long update(Employee employee) throws DaoException {

        long numberOfInsertedRows = 0;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);) {
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeEmail());
            preparedStatement.setString(3, employee.getEmployeeBirthdate().toString());
            preparedStatement.setInt(4, employee.getEmployeeUid());

            numberOfInsertedRows = preparedStatement.executeUpdate();
            return numberOfInsertedRows;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return numberOfInsertedRows;
    }
}
