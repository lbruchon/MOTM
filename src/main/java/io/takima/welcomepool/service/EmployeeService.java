package io.takima.welcomepool.service;

import io.takima.welcomepool.DAO.EmployeeDao;
import io.takima.welcomepool.model.Employee;

import javax.xml.rpc.ServiceException;
import java.util.List;

public class EmployeeService {

    public EmployeeService(EmployeeDao employeeDao) {
        super();
        this.employeeDao=employeeDao;
    }

    private EmployeeDao employeeDao = new EmployeeDao();

    public EmployeeService() {

    }

    public long create(Employee employee) {
        // TODO: créer un client


        return this.employeeDao.create(employee);

    }

    public List<Employee> findAll() throws ServiceException {
        // TODO: récupérer tous les clients

            return this.employeeDao.findAll();
    }

    public long delete(Employee employee) throws ServiceException, ClassNotFoundException {
        // TODO: créer un client

        return this.employeeDao.delete(employee);


    }

}
