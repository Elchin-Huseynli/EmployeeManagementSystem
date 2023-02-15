package service;

import exceptions.EmployeeNotFoundExceptions;
import exceptions.InvalidIdExceptions;
import exceptions.InvalidParameterExceptions;

public interface EmployeeService {
    boolean register();
    void showEmployee() throws EmployeeNotFoundExceptions;
    void findByName() throws EmployeeNotFoundExceptions;
    boolean update() throws EmployeeNotFoundExceptions, InvalidIdExceptions, InvalidParameterExceptions;
    boolean delete() throws EmployeeNotFoundExceptions, InvalidIdExceptions;
    void totalEmployee() throws EmployeeNotFoundExceptions;
}
