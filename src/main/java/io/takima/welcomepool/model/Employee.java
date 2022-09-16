package io.takima.welcomepool.model;

import java.time.LocalDate;
import java.util.Date;

public class Employee {
    private String name;
    private String email;
    private LocalDate birthdate;
    private int uuid;

    public Employee(String name, String email, LocalDate birthdate, int i) {
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        this.uuid = uuid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
