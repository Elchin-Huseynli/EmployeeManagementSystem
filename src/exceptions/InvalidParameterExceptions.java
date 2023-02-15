package exceptions;

import enums.ExceptionEnum;

public class InvalidParameterExceptions extends Exception{
    public InvalidParameterExceptions() {
        super("\n" + ExceptionEnum.INVALID_PARAMETER.name());
    }
}
