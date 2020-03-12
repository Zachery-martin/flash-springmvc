package edu.nf.flash.controller.advice;

import edu.nf.flash.controller.vo.ResponseVO;
import edu.nf.flash.service.exception.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: ControllerAspect
 * @Author: Zachery
 * @Data: 16:00
 **/
@RestControllerAdvice("edu.nf.flash.controller")
public class ControllerAspect {

    @ExceptionHandler(DataAccessException.class)
    public ResponseVO handleDataAccessException(DataAccessException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }
}
