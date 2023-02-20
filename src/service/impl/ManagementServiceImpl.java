package service.impl;
import enums.ExceptionEnum;
import enums.SuccessMessageEnum;
import exceptions.EmployeeNotFoundExceptions;
import exceptions.InvalidIdExceptions;
import exceptions.InvalidOptionExceptions;
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
                            System.out.println(SuccessMessageEnum.GOOD_BYE);
                            System.exit(-1);
                        case 1:
                            employeeService.register();
                            break;
                        case 2:
                            employeeService.showEmployee();
                            break;
                        case 3:
                            employeeService.update();
                            break;
                        case 4:
                            employeeService.delete();
                            break;
                        case 5:
                            employeeService.findByName();
                            break;
                        case 6:
                            employeeService.totalEmployee();
                            break;
                        default:
                            throw new InvalidOptionExceptions();
                    }
                }
            }
            catch (EmployeeNotFoundExceptions e) {
                System.out.println(e.getMessage());
            }
            catch (InvalidIdExceptions e) {
                System.out.println(e.getMessage());
            }
            catch (InvalidParameterExceptions e) {
                System.out.println(e.getMessage());
            }
            catch (InvalidOptionExceptions e) {
                System.out.println(e.getMessage());
            }
            catch (InputMismatchException e) {
                System.out.println("\n" + ExceptionEnum.MUST_BE_AN_INT_VALUE);
            }
        }
    }
}
