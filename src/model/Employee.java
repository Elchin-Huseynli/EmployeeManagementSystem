package model;

import java.time.LocalDate;

public class Employee extends Personal{
    private long id;
    private String department;
    private String position;
    private long salary;

    public Employee() {
        ++this.id;
    }

    public Employee(long id, String name, String surname, LocalDate birthday, String department, String position, long salary) {
        super(name, surname, birthday);
        this.id = id;
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                "\nSurname: " + getSurname() +
                "\nBirthday: " + getBirthday() +
                "\nDepartment: " + getDepartment() +
                "\nPosition: " + getPosition() +
                "\nSalary: " + getSalary();
    }
}
