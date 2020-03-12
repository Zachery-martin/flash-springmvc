package edu.nf.flash.service.exception;/**
 * @ClassName: LoginException
 * @Author: Zachery
 * @Data: 09:48
 **/

/**
 * @ClassName: LoginException
 * @Author: Zachery
 * @Data: 09:48
 **/
public class LoginException extends RuntimeException{

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }
}
