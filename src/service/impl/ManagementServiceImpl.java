package service.impl;
import exceptions.EmployeeNotFoundExceptions;
import exceptions.InvalidIdExceptions;
import exceptions.InvalidParameterExceptions;
import service.ManagementService;

import java.util.InputMismatchException;

import static util.MenuUtil.*;
public class ManagementServiceImpl implements ManagementService {

    @Override
    public void management() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        while (true) {
            try {
                while (true) {
                    int option = entryApp();
                    switch (option) {
                        case 0:
                            System.out.println("Good bye!");
                            System.exit(-1);
                        case 1:
                            employeeService.register();
                            break;
                        case 2:
                            try {
                                employeeService.showEmployee();
                            } catch (EmployeeNotFoundExceptions e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 3:
                            try {
                                employeeService.update();
                            } catch (EmployeeNotFoundExceptions e) {
                                System.out.println(e.getMessage());
                            } catch (InvalidIdExceptions e) {
                                System.out.println(e.getMessage());
                            } catch (InvalidParameterExceptions e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 4:
                            try {
                                employeeService.delete();
                            } catch (EmployeeNotFoundExceptions e) {
                                System.out.println(e.getMessage());
                            } catch (InvalidIdExceptions e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 5:
                            try {
                                employeeService.findByName();
                            } catch (EmployeeNotFoundExceptions e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 6:
                            employeeService.totalEmployee();
                            break;
                        default:
                            System.err.println("\nInvalid option!");
                    }
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\nMust be an int value!");
            }
        }
    }
}
