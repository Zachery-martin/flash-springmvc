package edu.nf.flash.controller.vo;/**
 * @ClassName: ResponseVO
 * @Author: Zachery
 * @Data: 16:07
 **/

/**
 * @ClassName: ResponseVO
 * @Author: Zachery
 * @Data: 16:07
 **/
public class ResponseVO<T> {
    private Integer code;
    private Object message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}