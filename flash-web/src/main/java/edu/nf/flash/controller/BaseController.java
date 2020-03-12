package edu.nf.flash.controller;/**
 * @ClassName: BaseController
 * @Author: Zachery
 * @Data: 16:06
 **/

import edu.nf.flash.controller.vo.ResponseVO;
import org.springframework.http.HttpStatus;

/**
 * @ClassName: BaseController
 * @Author: Zachery
 * @Data: 16:06
 **/
public class BaseController {

    protected <T> ResponseVO<T> success(T data){
        ResponseVO<T> vo = new ResponseVO<>();
        vo.setCode(HttpStatus.OK.value());
        vo.setData(data);
        return vo;
    }

    protected  ResponseVO success(Integer code){
        ResponseVO vo = new ResponseVO<>();
        vo.setCode(code);
        return vo;
    }

    protected ResponseVO success(String message){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.OK.value());
        vo.setMessage(message);
        return vo;
    }

    protected ResponseVO fail(Integer code){
        ResponseVO vo = new ResponseVO();
        vo.setCode(code);
        return vo;
    }

    protected ResponseVO fail(Integer code, String message){
        ResponseVO vo = new ResponseVO();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }
}
