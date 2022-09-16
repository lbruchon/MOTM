package io.takima.welcomepool.model;

public class Employee {
    private String name;
    private String email;
    private String birthdate;
    private int uuid;

    public Employee(String name, String email, String birthdate, int i) {
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }
}
