package io.takima.welcomepool.model;

import java.time.LocalDate;

public class Employee {
    public int EmployeeUid;
    private String EmployeeName;
    private String EmployeeEmail;
    private LocalDate EmployeeBirthdate;

    public Employee(int EmployeeUid, String EmployeeName, String EmployeeEmail, LocalDate EmployeeBirthdate) {
        this.EmployeeUid = EmployeeUid;
        this.EmployeeName = EmployeeName;
        this.EmployeeEmail = EmployeeEmail;
        this.EmployeeBirthdate = EmployeeBirthdate;
    }

    public int getEmployeeUid() {
        return EmployeeUid;
    }
}
