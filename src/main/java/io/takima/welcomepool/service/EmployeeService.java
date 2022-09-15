package io.takima.welcomepool.service;

import io.takima.welcomepool.DAO.EmployeeDao;
import io.takima.welcomepool.model.Employee;

public class EmployeeService {

    public EmployeeService(EmployeeDao employeeDao){
        super();
        this.employeeDao=employeeDao;
    }

    private EmployeeDao employeeDao;

    public long create(Employee employee){
        // TODO: créer un client

        return this.employeeDao.create(employee);

    }

}
