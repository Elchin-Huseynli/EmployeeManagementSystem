package exceptions;

import enums.ExceptionEnum;

public class EmployeeNotFoundExceptions extends Exception{
    public EmployeeNotFoundExceptions() {
        super("\n" + ExceptionEnum.EMPLOYEE_NOT_FOUND.name());
    }
}
