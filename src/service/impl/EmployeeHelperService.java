package service.impl;

import model.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static util.InputUtil.InputTypeLong;
import static util.InputUtil.InputTypeString;

public class EmployeeHelperService {
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
        LocalDateTime createDate = LocalDateTime.now().withNano(0);
        LocalDateTime updateDate = LocalDateTime.now().withNano(0);

        Employee employee = new Employee(++id,name,surname,birthday,department,position,salary,createDate,updateDate);
        return employee;
    }
}
