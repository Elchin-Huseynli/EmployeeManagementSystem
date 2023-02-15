package service.impl;

import exceptions.EmployeeNotFoundExceptions;
import exceptions.InvalidIdExceptions;
import exceptions.InvalidParameterExceptions;
import global.GlobalData;
import model.Employee;
import service.EmployeeService;
import java.time.*;
import static util.InputUtil.*;

public class EmployeeServiceImpl implements EmployeeService {

    static long id = 0;

    static LocalDate birthdayDate() {
        String birthday = InputTypeString("Enter the birthday(dd/MM/yyyy): ");
        String[] strArr = birthday.split("/");
        int day = Integer.parseInt(strArr[0]);
        int month = Integer.parseInt(strArr[1]);
        int year = Integer.parseInt(strArr[2]);
        LocalDate date = LocalDate.of(year,month,day);

        return date;
    }
    static Employee fillEmployee() {
        String name = InputTypeString("Enter the name: ");
        String surname = InputTypeString("Enter the surname: ");
        LocalDate birthday = birthdayDate();
        String department = InputTypeString("Enter the department: ");
        String position = InputTypeString("Enter the position: ");
        long salary = InputTypeLong("Enter the salary: ");

        Employee employee = new Employee(++id,name,surname,birthday,department,position,salary);
        return employee;
    }

    @Override
    public boolean register() {
            int count = InputTypeInt("How many employee register: ");
            if (GlobalData.employees != null) {
                Employee[] tempEmployee = GlobalData.employees;
                GlobalData.employees = new Employee[count + tempEmployee.length];

                for (int i = 0, k = 0; i < GlobalData.employees.length; i++) {
                    if (i < tempEmployee.length) {
                        GlobalData.employees[i] = tempEmployee[i];
                    }
                    else {
                        System.out.println("-------------------");
                        System.out.println(++k + ". Employee");
                        GlobalData.employees[i] = fillEmployee();
                        System.out.println("-------------------");
                    }
                }
            }
            else {
                GlobalData.employees = new Employee[count];

                for (int i = 0; i < count; i++) {
                    System.out.println("-------------------");
                    System.out.println(i+1 + ". Employee");
                    GlobalData.employees[i] = fillEmployee();
                    System.out.println("-------------------");
                }
            }
            System.out.println("Registered successful!");
            System.out.println("Total employee: " + GlobalData.employees.length + "\n");

        return false;
    }

    @Override
    public void showEmployee() throws EmployeeNotFoundExceptions {
        if (GlobalData.employees == null) {
            throw new EmployeeNotFoundExceptions();
        }
        else {
            for (int i = 0; i < GlobalData.employees.length; i++) {
                System.out.println("-------------------");
                System.out.println(i+1 + ". Employee");
                System.out.println(GlobalData.employees[i]);
                System.out.println("-------------------");
            }
        }
    }

    @Override
    public void findByName() throws EmployeeNotFoundExceptions {
        if (GlobalData.employees == null) {
            throw new EmployeeNotFoundExceptions();
        }
        else {
            String name = InputTypeString("Enter the name: ");
            for (int i = 0; i < GlobalData.employees.length; i++) {
                if (GlobalData.employees[i].getName().contains(name)) {
                    System.out.println("-------------------");
                    System.out.println(i+1 + ". Employee");
                    System.out.println(GlobalData.employees[i]);
                    System.out.println("-------------------");
                }
//                else {
//                    throw new EmployeeNotFoundExceptions();
//                }
            }
        }
    }

    @Override
    public boolean update() throws EmployeeNotFoundExceptions, InvalidIdExceptions, InvalidParameterExceptions {
            boolean isUpdated = false;
        if (GlobalData.employees == null) {
            throw new EmployeeNotFoundExceptions();
        }
        else {
            int id = InputTypeInt("Which employee do you want to update: ");
            for (int i = 0; i < GlobalData.employees.length; i++) {
                if (GlobalData.employees[i].getId() == id) {
                    String newParameter = InputTypeString("Which parameter you want to change: ");
                    String[] newParameterArr = newParameter.toLowerCase().split(",");
                    for (int j = 0; j < newParameterArr.length; j++) {
                        if (newParameterArr[j].equals("name")) {
                            GlobalData.employees[i].setName(InputTypeString("Update name: "));
                            isUpdated = true;
                        }
                        if (newParameterArr[j].contains("surname") & !newParameterArr[j].equals("name")) {
                            GlobalData.employees[i].setSurname(InputTypeString("Update surname: "));
                            isUpdated = true;
                        }
                        if (newParameterArr[j].contains("birthday")) {
                            GlobalData.employees[i].setBirthday(birthdayDate());
                            isUpdated = true;
                        }
                        if (newParameterArr[j].contains("department")) {
                            GlobalData.employees[i].setDepartment(InputTypeString("Update department: "));
                            isUpdated = true;
                        }
                        if (newParameterArr[j].contains("position")) {
                            GlobalData.employees[i].setPosition(InputTypeString("Update position: "));
                            isUpdated = true;
                        }
                        if (newParameterArr[j].contains("salary")) {
                            GlobalData.employees[i].setSalary(InputTypeLong("Update salary: "));
                            isUpdated = true;
                        }
                    }
                    if (isUpdated == true) {
                        System.out.println("\nUpdate successfully!");
                    }
                    else if (isUpdated == false) {
                        throw new InvalidParameterExceptions();
                    }
                }
//                else {
//                    throw new InvalidIdExceptions();
//                }
            }
        }
        return isUpdated;
    }

    @Override
    public boolean delete() throws EmployeeNotFoundExceptions, InvalidIdExceptions {
        boolean isDeleted = false;
        if (GlobalData.employees == null) {
            throw new EmployeeNotFoundExceptions();
        }
        else {
            int id = InputTypeInt("Which employee do you want to delete: ");
            for (int i = 0; i < GlobalData.employees.length; i++) {
                if (GlobalData.employees[i].getId() == id) {
                    Employee[] tempEmployee = GlobalData.employees;
                    GlobalData.employees = new Employee[tempEmployee.length-1];
                    for (int j = 0; j < tempEmployee.length; j++) {
                        if (tempEmployee[j].getId() == id) {
                            continue;
                        }
                        GlobalData.employees[j] = tempEmployee[j];
                    }
                    isDeleted = true;
                }
                else {
                    isDeleted=false;
                }
            }
            if (isDeleted == true) {
                System.out.println("\nDeleted successfully!");
            }
            else {
                throw new InvalidIdExceptions();
            }
        }
        return isDeleted;
    }

    @Override
    public void totalEmployee() {
        if (GlobalData.employees == null) {
            System.out.println("\nTotal employee count: 0");
        }
        else {
            System.out.println("\nTotal employee count: " + GlobalData.employees.length);
        }
    }
}
