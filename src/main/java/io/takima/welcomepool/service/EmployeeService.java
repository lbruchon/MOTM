package io.takima.welcomepool.service;

import io.takima.welcomepool.dao.EmployeeDAO;
import io.takima.welcomepool.exception.DaoException;
import io.takima.welcomepool.exception.ServiceException;
import io.takima.welcomepool.model.Employee;

public class EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        super();
        this.employeeDAO = employeeDAO;
    }

    public long create(Employee employee) throws ServiceException {
        try {
            return this.employeeDAO.create(employee);
        } catch (DaoException exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public long update(Employee employee) throws ServiceException {
        try {
            return this.employeeDAO.update(employee);
        } catch (DaoException exception) {
            exception.printStackTrace();
        }
        return 0;
    }

}
