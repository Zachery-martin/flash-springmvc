package edu.nf.flash.service.exception;/**
 * @ClassName: DataAccessException
 * @Author: Zachery
 * @Data: 15:41
 **/

/**
 * @ClassName: DataAccessException
 * @Author: Zachery
 * @Data: 15:41
 **/
public class DataAccessException extends RuntimeException {
    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessException(Throwable cause) {
        super(cause);
    }
}
