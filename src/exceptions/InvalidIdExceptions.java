package exceptions;

import enums.ExceptionEnum;

public class InvalidIdExceptions extends Exception{
    public InvalidIdExceptions() {
        super("\n" + ExceptionEnum.INVALID_ID.name());
    }
}
