package exceptions;

import enums.ExceptionEnum;

public class InvalidOptionExceptions extends Exception{
    public InvalidOptionExceptions() {
        super("\n" + ExceptionEnum.INVALID_OPTION.name());
    }
}
